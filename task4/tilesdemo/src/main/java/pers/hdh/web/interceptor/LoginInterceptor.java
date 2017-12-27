package pers.hdh.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pers.hdh.model.User;
import pers.hdh.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    private final static int TOKEN_LIFECYCLE = 1800;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 从cookie获取token
        Cookie cookie = CookieUtils.getCookieByName("token", request.getCookies());
        if (cookie != null) {
            String token = cookie.getValue();

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("USER_" + token);
            if (user != null) {
                // 刷新cookie存活时间
                CookieUtils.addCookie(cookie, "/", TOKEN_LIFECYCLE, response);
                // 刷新session域存活的时间
                session.setMaxInactiveInterval(TOKEN_LIFECYCLE);
                return true;
            }
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("after");
    }
}
