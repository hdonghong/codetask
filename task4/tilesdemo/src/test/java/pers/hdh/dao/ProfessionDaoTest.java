package pers.hdh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hdh.model.Profession;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProfessionDaoTest {

    @Resource
    private ProfessionDao professionDao;

    @Test
    public void findAll() throws Exception {
        List<Profession> professionList = professionDao.findAll(0, 3);
        for (Profession profession : professionList) {
            System.out.println(profession);
        }

    }

    @Test
    public void getById() throws Exception {
        Profession profession = professionDao.getById(1l);
        System.out.println(profession);
    }



}