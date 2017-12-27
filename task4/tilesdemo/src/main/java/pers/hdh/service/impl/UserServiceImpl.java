package pers.hdh.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.UserDao;
import pers.hdh.model.User;
import pers.hdh.service.UserService;
import pers.hdh.utils.CookieUtils;
import pers.hdh.utils.MD5Utils;
import pers.hdh.utils.SecretUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) throws Exception {
        User user = userDao.login(username, password);

        if (user != null) {
            // 清空密码
             user.setPassword(null);
            // 用户id和登录时间使用dec加密
            user.setUid(SecretUtil.encrypt(user.getUid()));
            user.setLoginAt(SecretUtil.encrypt(System.currentTimeMillis()+""));
            //或者：用户id和登录时间使用MD5加密
//            user.setUid(MD5Utils.md5(user.getUid()));
//            user.setLoginAt(MD5Utils.md5(System.currentTimeMillis()+""));
        }
        return user;
    }

    @Override
    public void regist(User user) {
        userDao.regist(user);
    }

}
