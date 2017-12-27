package pers.hdh.service;

import pers.hdh.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 用户通过username和password登录，对uid和登录时间加密
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    User login(String username, String password) throws Exception;

    /**
     * 用户注册
     * @param user
     */
    void regist(User user);
}
