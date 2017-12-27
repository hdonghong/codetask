package pers.hdh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hdh.model.Applicant;
import pers.hdh.service.ApplicantService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ApplicantServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicantService applicantService;

    @Test
    public void testFindAll() throws Exception {
        List<Applicant> applicantList = applicantService.findAll(0, 4);
        for(Applicant applicant : applicantList) {
            logger.info(applicant.toString());
        }

        /**
         [INFO ] 2017-12-22 15:40:25,130 METHOD:pers.hdh.service.impl.ApplicantServiceTest.testFindAll(ApplicantServiceTest.java:30):Applicant{id=4, create_at=1504412628000, update_at=1504414970000, name='黄蓉', type='JAVA工程师', description='老大最帅'}
         [INFO ] 2017-12-22 15:40:25,130 METHOD:pers.hdh.service.impl.ApplicantServiceTest.testFindAll(ApplicantServiceTest.java:30):Applicant{id=5, create_at=1504413087000, update_at=1504413314000, name='张三', type='JAVA工程师', description='努力奋斗，有付出才有'}
         [INFO ] 2017-12-22 15:40:25,130 METHOD:pers.hdh.service.impl.ApplicantServiceTest.testFindAll(ApplicantServiceTest.java:30):Applicant{id=6, create_at=1504413095000, update_at=1504413315000, name='李四', type='JAVA工程师', description='努力奋斗，有付出才有'}
         [INFO ] 2017-12-22 15:40:25,131 METHOD:pers.hdh.service.impl.ApplicantServiceTest.testFindAll(ApplicantServiceTest.java:30):Applicant{id=7, create_at=1504413103000, update_at=1504413315000, name='王五', type='JAVA工程师', description='努力奋斗，有付出才有'}
         */
    }

}