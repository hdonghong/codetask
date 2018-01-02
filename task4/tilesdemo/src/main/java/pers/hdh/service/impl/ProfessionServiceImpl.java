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

    @Override
    public List<Profession> findAll(int offset, int limit) {
        List<Profession> professionList = null;
        try {
            // 从memcache中获取applicantList数据
            // professionList = memcachedClient.get("professionList");
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
}
