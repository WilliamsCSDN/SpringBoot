package com.dubbo.customer.filter;

import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserInterceptor implements HandlerInterceptor {

    public static String SESSION_TOKEN;

    public static String SESSION_PASSWORD;

    public static String SESSION_USER;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getMethod().equals("OPTIONS")){
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
//            httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
            return true;
        }

        String token = httpServletRequest.getHeader("token");
        if (null != token) {
            List<User> users = (List<User>) userService.getUser("", "", token);
            for (User user : users) {
                SESSION_USER = user.getName();
                SESSION_PASSWORD = user.getPassword();
                SESSION_TOKEN=token;
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
