package pers.hdh.dao;

import org.apache.ibatis.annotations.Param;
import pers.hdh.model.User;

/**
 * 用户的持久层
 * @author hdonghong
 */
public interface UserDao {

    /**
     * 用户登录，通过用户名和密码查询数据库中唯一用户
     * @param username 用户名
     * @param password 密码
     * @return 将获取到的一条记录封装成User对象作为返回结果
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 添加一条记录到user表中
     * @param user
     */
    void regist(User user);
}
