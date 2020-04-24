package com.dubbo.customer.controller;


import com.alibaba.dubbo.common.serialize.Serialization;
import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.customer.filter.TestInterceptor;
import com.dubbo.customer.filter.UserInterceptor;
import com.dubbo.customer.util.CodeUtil;
import com.dubbo.customer.util.Constants;
import com.dubbo.customer.util.MD5Util;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
public class UserController {
    public String token="";
    public static String code="";
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;
    @Resource
    CodeUtil codeUtil;


    @RequestMapping("/getAllUser")
    public Object getAllUser(){
        List<User> users = userService.findAll();
        if(users != null) {
            logger.info("用户: {} 查询所有用户",UserInterceptor.SESSION_USER);
            return users;
        }
        else {
            logger.error("用户: {} 暂无用户",UserInterceptor.SESSION_USER);
            return "暂无用户";
        }
    }

    @RequestMapping("/getUser")
    public Object getUser(HttpServletResponse response, HttpServletRequest request, String username, String password, String token){
           Object a = userService.getUser(username, password, token);
           if(token == null) {
               String md5password = MD5Util.formPassToDBPass(password, "456789");
               UsernamePasswordToken tk = new UsernamePasswordToken(username,md5password);
               Subject subject = SecurityUtils.getSubject();
               subject.login(tk);
               if(subject.isAuthenticated()){
                   logger.info("用户: {} 登录成功", UserInterceptor.SESSION_USER);
               }
           }
           return a;
    }
    @RequestMapping("/deleteById")
    public String deleteById(String id){
        if(id != null) {
            int a = userService.deleteById(id);
            if(a>0){
                logger.info("用户: {} 删除用户ID{}成功", UserInterceptor.SESSION_USER,id);
                return "删除用户成功";
            }
            else {
                logger.error("用户: {} 删除用户ID{}失败", UserInterceptor.SESSION_USER,id);
                return "删除用户失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/findByUsername")
    public Object findByUsername(String username){

            User user = userService.findByUsername(username);
            if(user != null) {
                logger.info("用户: {} 删除用户{}成功", UserInterceptor.SESSION_USER,username);
                return user;
            }
            else {
                logger.error("用户: {} 删除用户{}失败", UserInterceptor.SESSION_USER,username);
                return "";
            }

    }
    @RequestMapping("/findById")
    public Object findById(String id){
        logger.info("用户: {} 查找用户ID{}成功", UserInterceptor.SESSION_USER,id);
        return userService.findById(id);
    }
    @RequestMapping("/remove")
    public String remove(String token){
        Subject subject = SecurityUtils.getSubject();
        if(token != null) {
            int a = userService.remove(token);
            if(a>0) {
                subject.logout();

                logger.info("用户: {} 退出登录(删除token成功)", UserInterceptor.SESSION_USER);
                UserInterceptor.SESSION_USER="";
                return "删除token成功";
            }
            else {
                logger.error("用户: {} 退出登录(删除token失败)", UserInterceptor.SESSION_USER);
                return "删除token失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/registerUser")
    public String register(String username,String password,String identity){
        if(username != null && password != null && identity != null){
            int a = userService.register(username, password, identity);
            if(a>0){
                logger.info("注册用户{}密码{}成功)",username,password);
                return "注册用户成功";
            }
            else{
                logger.error("注册用户{}密码{}失败",username,password);
                return "注册用户失败";
            }
        }else return "参数缺失";
    }

    @RequestMapping("/findByName")
    public Object findByName(String username, String password){
        if(username != null && password != null) {
            List<User> users = userService.findByName(username, password);
            if(users != null) {
                logger.info("用户 : {}存在",username);
                return users;
            }
            else {
                logger.error("用户 : {}不存在", username);
                return "用户不存在";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/getpermission")
    public Object getpermission(String iid){

        if(iid != null) {
            List<Permission> permissions = userService.getpermission(iid);
            if(permissions != null) {
                logger.info("用户 : {} 查询权限成功",UserInterceptor.SESSION_USER);
                return permissions;
            }
            else {
                logger.error("用户 : {} 查询权限失败",UserInterceptor.SESSION_USER);
                return null;
            }
        }else return "参数缺失";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.updateUser(user);
            if(a>0) {
                logger.info("用户 : {} 修改用户ID{}成功",UserInterceptor.SESSION_USER,user.getId());
                return "修改用户成功";
            }
            else {
                logger.error("用户 : {} 修改用户ID{}失败",UserInterceptor.SESSION_USER,user.getId());
                return "修改用户失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updateUser1")
    public String updateUser1(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.updateUser1(user);
            if(a>0) {
                logger.info("用户 : {} 修改用户ID{}信息成功",UserInterceptor.SESSION_USER,user.getId());
                return "修改用户信息成功";
            }
            else {
                logger.error("用户 : {} 修改用户ID{}信息失败",UserInterceptor.SESSION_USER,user.getId());
                return "修改用户信息失败";
            }
        }else return "参数缺失!";
    }
    @RequestMapping("/updatePassword")
    public String updatePassword(String username,String password,String oldpassword){
        if(username != null && password != null && oldpassword != null) {
            int a = userService.updatePassword(username, password, oldpassword);
            if(a>0) {
                logger.info("用户 : {} 修改用户{}密码成功",UserInterceptor.SESSION_USER,username);
                return "修改密码成功";
            }
            else {
                logger.error("用户 : {} 修改用户{}密码失败",UserInterceptor.SESSION_USER,username);
                return "修改密码失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/addUser")
    public String addUser(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.addUser(user);
            if(a>0) {
                logger.info("添加用户成功");
                return "添加用户成功";
            }
            else {
                logger.error("添加用户失败");
                return "添加用户失败";
            }
        }else return "参数缺失";
    }

    @RequestMapping("/code")
    public void getCode (HttpServletResponse response){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        code= codeUtil.drawImg(output);
        Cookie cookie = new Cookie("code",code);
        response.addCookie(cookie);

        try {
            ServletOutputStream out=response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/code1")
    public String getCode1 (){
        logger.info("获取到的验证码为{}",code);
       return code;
    }
}
