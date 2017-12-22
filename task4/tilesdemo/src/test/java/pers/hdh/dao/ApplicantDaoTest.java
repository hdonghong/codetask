package pers.hdh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hdh.model.Applicant;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIoc容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ApplicantDaoTest {

    // 注入Dao实现类依赖
    @Resource
    private ApplicantDao applicantDao;

    @Test
    public void findAll() throws Exception {
        /**
         * Caused by: org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         */
        // Java没有保存形参的记录: findAll(int offset, int limit) -> findAll(int arg0, int arg1)
        // 通过 @Param 进行绑定
        /**
           Applicant{id=4, create_at=1504412628000, update_at=1504414970000, name='黄蓉', type='JAVA工程师', description='老大最帅'}
           Applicant{id=5, create_at=1504413087000, update_at=1504413314000, name='张三', type='JAVA工程师', description='努力奋斗，有付出才有'}
           Applicant{id=6, create_at=1504413095000, update_at=1504413315000, name='李四', type='JAVA工程师', description='努力奋斗，有付出才有'}
           Applicant{id=7, create_at=1504413103000, update_at=1504413315000, name='王五', type='JAVA工程师', description='努力奋斗，有付出才有'}
         */

        List<Applicant> applicantsList = applicantDao.findAll(0, 4);
        for (Applicant applicant: applicantsList) {
            System.out.println(applicant);
        }
    }

}