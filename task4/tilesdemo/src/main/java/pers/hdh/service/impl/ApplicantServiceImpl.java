package pers.hdh.service.impl;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.ApplicantDao;
import pers.hdh.model.Applicant;
import pers.hdh.service.ApplicantService;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private ApplicantDao applicantDao;

    // 注入memcached
    @Autowired
    private MemcachedClient memcachedClient;

    @Override
//    @Tranactional
    /**
     * 使用注解控制事务方法的有点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格。
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求获取剥离到事务方法外部。
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public List<Applicant> findAll(int offset, int limit) {
        List<Applicant> applicantList = null;
        try {
            // 从memcache中获取applicantList数据
            applicantList = memcachedClient.get("applicantList");
            if (applicantList == null) {
                // 如果缓存中不存在则进行数据库查询，并将结果放入memcache中
                applicantList = applicantDao.findAll(offset, limit);
//              You can use "set" to store data, it has 3 parameters,
//              the first is key name
//              the second is expire time (second), after the expire time, you can't find the key in memcached server.
//              The third parameter is the data for store, it can be any java serialized object
//              from https://github.com/killme2008/xmemcached/wiki/User-Guide
                memcachedClient.set("applicantList", 3600, applicantList);
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }

        return applicantList;
    }
}
