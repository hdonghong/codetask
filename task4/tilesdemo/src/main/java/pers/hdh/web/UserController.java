package pers.hdh.web;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.hdh.model.User;
import pers.hdh.service.UserService;
import pers.hdh.utils.CCPRestSmsUtils;
import pers.hdh.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param request
     * @param response
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("username") String username, @RequestParam("password") String password,
                        Model model) {
        try {
            User user = userService.login(username,password);
            if (user != null) {
                // 生成token
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                // token放入cookie中
                CookieUtils.addCookie(new Cookie("token", token), "/", 1800, response);
                // 设置session
                HttpSession session = request.getSession();
                session.setAttribute("USER_" + token, user);
                // 放入session中设置半小时
                session.setMaxInactiveInterval(1800);
                // 重定向
                response.sendRedirect(request.getContextPath() + "/applicant/list");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 信息错误时返回提示
        request.setAttribute("message", "用户名或密码错误");
        return "login";
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtils.getCookieByName("token", request.getCookies());
        if (cookie != null) {
            // 删除cookie
            cookie.setValue(null);
            CookieUtils.addCookie(cookie, "/", 0, response);
            // 清除session
            request.getSession().invalidate();
        }
        try {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="regist", method = RequestMethod.POST)
    public String regist(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("phone") String phone, @RequestParam("email") String email,
                         @RequestParam("head") String head) {
        User user = new User();
        user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setHead(head);

        // 调用业务逻辑层进行注册操作
        userService.regist(user);
        try {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    private CCPRestSmsUtils restAPIUtils;

    @RequestMapping(value="checkCode", method = RequestMethod.POST)
    public void checkCode(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("phone") String phone) {
        // 生成随机验证码
        int randomCode = new Random().nextInt(10000) % (10000 - 1000 + 1) + 1000;

        HashMap<String, Object> result = null;

        CCPRestSmsSDK restAPI = restAPIUtils.getRestAPI();
        result = restAPI.sendTemplateSMS(phone,"1" ,new String[]{randomCode+"", "1"});

        if(!("000000".equals(result.get("statusCode")))){
            // 进行异常处理，异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }

        try {
            response.getWriter().print(randomCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args ) {
        for (int i = 1; i < 1000; i++) {
            int randomCode = new Random().nextInt(10000) % (10000 - 1000 + 1) + 1000;
            System.out.println(randomCode);
        }
    }
}
