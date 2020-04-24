package com.dubbo.customer.filter;

import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.customer.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class TestInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String token=httpServletRequest.getHeader("Cookie");
        Cookie[] cookies=httpServletRequest.getCookies();
        if(null != cookies){
            for(Cookie cookie : cookies){
                if("token".equals(cookie.getName())) {
                    System.out.println(cookie.getValue());
                   List<User> users=(List<User>)userService.getUser("","",cookie.getValue());
                   for(User user :users)
                   if(user.getUsername() != null && user.getPassword() != null) {
                       System.out.println(user.getName());
                       return true;
                   }else return false;
                }else return false;
            }
        }
        System.out.println("查无此人");
        return false;
//        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
