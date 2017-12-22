package pers.hdh.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.ApplicantDao;
import pers.hdh.model.Applicant;
import pers.hdh.service.ApplicantService;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private ApplicantDao applicantDao;

    @Override
//    @Tranactional
    /**
     * 使用注解控制事务方法的有点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格。
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求获取剥离到事务方法外部。
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public List<Applicant> findAll(int offset, int limit) {
        return applicantDao.findAll(offset, limit);
    }
}
