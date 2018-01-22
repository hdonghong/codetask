package pers.hdh.service.impl;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.dao.UserDao;
import pers.hdh.model.Email;
import pers.hdh.model.User;
import pers.hdh.service.UserService;
import pers.hdh.utils.CookieUtils;
import pers.hdh.utils.MD5Utils;
import pers.hdh.utils.SecretUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    private Email email;

    @Override
    public void regist(User user) {
        userDao.regist(user);
        // 成功持久化用户信息到数据库后发送邮件，表示网站欢迎新用户的注册

        try {
            String html = "<html><p>欢迎新用户：" + user.getUsername() +"，您已成功注册！</p></html>";

            HttpPost httpPost = new HttpPost(email.getUrl());
            CloseableHttpClient httpClient = HttpClients.createDefault();

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("api_user", email.getApiUser()));
            params.add(new BasicNameValuePair("api_key", email.getApiKey()));
            params.add(new BasicNameValuePair("to", email.getRcpt_to()));
            params.add(new BasicNameValuePair("from", email.getFrom()));
            params.add(new BasicNameValuePair("fromname", email.getFromname()));
            params.add(new BasicNameValuePair("subject", email.getSubject()));
            params.add(new BasicNameValuePair("html", html));
            params.add(new BasicNameValuePair("resp_email_id", email.getResp_email_id()));

            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);

            // 处理响应
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.err.println("error");
            }
            httpPost.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
