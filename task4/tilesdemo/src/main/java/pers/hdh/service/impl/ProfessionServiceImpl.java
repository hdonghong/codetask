package pers.hdh.service.impl;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.ProfessionDao;
import pers.hdh.model.Applicant;
import pers.hdh.model.Profession;
import pers.hdh.service.ProfessionService;
import pers.hdh.utils.FastJsonUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionDao professionDao;

    // 注入memcached
    @Autowired
    private MemcachedClient memcachedClient;

    // 注入JedisPool
    @Autowired
    private JedisPool jedisPool;

    @Override
    public List<Profession> findAll(int offset, int limit) {
        List<Profession> professionList = null;
        try {
            // 从memcache中获取applicantList数据
            professionList = memcachedClient.get("professionList");
            if (professionList == null) {
                // 如果缓存中不存在则进行数据库查询，并将结果放入memcache中
                professionList = professionDao.findAll(offset, limit);
//              You can use "set" to store data, it has 3 parameters,
//              the first is key name
//              the second is expire time (second), after the expire time, you can't find the key in memcached server.
//              The third parameter is the data for store, it can be any java serialized object
//              from https://github.com/killme2008/xmemcached/wiki/User-Guide
                memcachedClient.set("professionList", 3600, professionList);
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return professionList;
    }

    @Override
    public List<Profession> findAllByRedis(int offset, int limit) {
        Jedis jedis = jedisPool.getResource();
        List<Profession> professionList = null;

        // 从缓存中获取数据，但不能影响正常的业务逻辑
        try {
            String jsonData = jedis.hget("profession_list", "f_profession");
            if (jsonData != null) {
                professionList = FastJsonUtils.jsonToList(jsonData, Profession.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (professionList == null) {
            professionList = professionDao.findAll(offset, limit);
            // 将数据放入redis中，但不能影响正常的业务逻辑
            try {
                jedis.hset("profession_list", "f_profession", FastJsonUtils.toJSONString(professionList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 释放连接
        jedis.close();

        return professionList;
    }

    @Override
    public Profession getById(Long id) {
        if (id != null) {
            try {
                // 从memcached缓存中获取指定id的profession
                Profession profession = memcachedClient.get("profession_" + id );
                if (profession == null) {
                    // 获取不到则查询数据库并将获取到的数据放入缓存中
                    profession = professionDao.getById(id);
                    memcachedClient.set("profession_" + id, 3600, profession);
                }
                return profession;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Profession getByIdRedis(Long id) {
        if (id != null) {
            Jedis jedis = jedisPool.getResource();
            Profession profession = null;
            try {
                // 从redis缓存中获取指定id的profession
                String jsonData = jedis.get("profession_" + id );
                if (jsonData != null) {
                   profession = FastJsonUtils.jsonToList(jsonData, Profession.class).get(0);
                }
                if (profession == null) {
                    // 获取不到则查询数据库并将获取到的数据放入缓存中
                    profession = professionDao.getById(id);
                    List<Profession> list = new ArrayList<>();
                    list.add(profession);
                    jedis.set("profession_" + id, FastJsonUtils.toJSONString(list));
                }
                return profession;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jedis.close();
            }
        }
        return null;
    }
}
