package pers.hdh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hdh.model.Profession;
import pers.hdh.service.ProfessionService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ProfessionServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionService professionService;

    @Test
    public void findAll() throws Exception {
        List<Profession> professionList = professionService.findAll(0, 3);
        for (Profession profession : professionList) {
            logger.info(profession.toString());
        }
        /**
         [INFO ] 2017-12-22 22:39:35,649 METHOD:pers.hdh.service.impl.ProfessionServiceImplTest.findAll(ProfessionServiceImplTest.java:31):Profession{id=1, create_at=null, update_at=null, job='Web前端工程师', description='Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。', level=1, degree=2, demand=345, students=286, message='在你学习之前你应该已经掌握CSS、JS等语言基础'}
         [INFO ] 2017-12-22 22:39:35,649 METHOD:pers.hdh.service.impl.ProfessionServiceImplTest.findAll(ProfessionServiceImplTest.java:31):Profession{id=2, create_at=null, update_at=null, job='JAVA后端工程师', description='JAVA后端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发', level=3, degree=4, demand=1999, students=9991, message='在你学习之前应该事先掌握了JavaSe基础'}
         [INFO ] 2017-12-22 22:39:35,649 METHOD:pers.hdh.service.impl.ProfessionServiceImplTest.findAll(ProfessionServiceImplTest.java:31):Profession{id=3, create_at=null, update_at=null, job='iOS工程师', description='iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。', level=2, degree=3, demand=888, students=666, message='在你学习之前应事先学习过一门编程语言'}
         */
    }

    @Test
    public void getById() throws Exception {
        Profession profession = professionService.getById(1l);
        logger.info(profession.toString());
    }

    @Test
    public void findAllByRedis() throws Exception {
        List<Profession> professionList = professionService.findAllByRedis(0, 3);
        for (Profession profession : professionList) {
            logger.info(profession.toString());
        }
    }

    @Test
    public void getByIdRedis() throws Exception {
        Profession profession = professionService.getByIdRedis(1l);
        logger.info(profession.toString());
    }

}