package com.dubbo.customer.filter;

import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.customer.controller.UserController;
import com.dubbo.customer.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class TestInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String SESSION_USER;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getMethod().equals("OPTIONS")){
            logger.info("浏览器的预请求的处理..");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
//            httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
            return true;
        }


            String token = httpServletRequest.getHeader("token");
//            logger.info("token：" + token);
            if (null != token) {
                        List<User> users = (List<User>) userService.getUser("", "", token);
                        for (User user : users)
                            if (user.getUsername() != null && user.getPassword() != null) {
//                                System.out.println(user.getName());
                                Cookie cookie=new Cookie("name",user.getName());
                                httpServletResponse.addCookie(cookie);
                                SESSION_USER=user.getName();
                                return true;
                            } else return false;
            }
            UserInterceptor.SESSION_USER="";
            System.out.println("需要先登录!");
            return false;


    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
