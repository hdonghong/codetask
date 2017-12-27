package pers.hdh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.hdh.model.User;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void login() throws Exception {
        User user = userDao.login("tom", "123");
        System.out.println(user);
    }

    @Test
    public void regist() throws Exception {
        User user = new User();
        user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setUsername("admin");
        user.setPassword("123");

        userDao.regist(user);
    }

}