package com.dubbo.customer.controller;


import com.alibaba.dubbo.common.serialize.Serialization;
import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.customer.util.CodeUtil;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @Resource
    UserService userService;
    @Resource
    CodeUtil codeUtil;


    @RequestMapping("/getAllUser")
    public Object getAllUser(){
        List<User> users = userService.findAll();
        if(users != null) return users;
        else return "暂无用户!";
    }

    @RequestMapping("/getUser")
    public Object getUser(HttpServletResponse response, HttpServletRequest request, String username, String password, String token){
           Object a = userService.getUser(username, password, token);
           if(token == null) {

//               response.setHeader("Access-Control-Allow-Credentials","true");
//               response.setHeader("Access-Control-Allow-Origin","http://localhost:8081");
//
//               response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
//               Cookie cookie = new Cookie("token", (String) a);
//               cookie.setMaxAge(24 * 3600);
//               cookie.setPath("/");
//               response.addCookie(cookie);
           }
           return a;
    }
    @RequestMapping("/deleteById")
    public String deleteById(String id){
        if(id != null) {
            int a = userService.deleteById(id);
            if(a>0) return "删除用户成功!";
            else return "删除用户失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/findByUsername")
    public Object findByUsername(String username){

            User user = userService.findByUsername(username);
            if(user != null) return user;
            else return "";

    }
    @RequestMapping("/findById")
    public Object findById(String id){
        return userService.findById(id);
    }
    @RequestMapping("/remove")
    public String remove(String token){
        if(token != null) {
            int a = userService.remove(token);
            if(a>0) return "删除token成功!";
            else return "删除token失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/registerUser")
    public String register(String username,String password,String identity){
        if(username != null && password != null && identity != null){
            int a = userService.register(username, password, identity);
            if(a>0) return "注册用户成功!";
            else return "注册用户失败!";
        }else return "参数缺失!";
    }

    @RequestMapping("/findByName")
    public Object findByName(String username, String password){
        if(username != null && password != null) {
            List<User> users = userService.findByName(username, password);
            if(users != null) return users;
            else return "用户不存在!";
        }else return "参数缺失!";
    }
    @RequestMapping("/getpermission")
    public Object getpermission(String iid){
        if(iid != null) {
            List<Permission> permissions = userService.getpermission(iid);
            if(permissions != null) return permissions;
            else return null;
        }else return "参数缺失!";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.updateUser(user);
            if(a>0) return "修改用户成功!";
            else return "修改用户失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/updateUser1")
    public String updateUser1(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.updateUser1(user);
            if(a>0) return "修改用户成功!(除密码)";
            else return "修改用户失败!(除密码)";
        }else return "参数缺失!";
    }
    @RequestMapping("/updatePassword")
    public String updatePassword(String username,String password,String oldpassword){
        if(username != null && password != null && oldpassword != null) {
            int a = userService.updatePassword(username, password, oldpassword);
            if(a>0) return "修改密码成功!";
            else return "修改密码失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/addUser")
    public String addUser(User user){
        if(user != null && user.getUsername() != null) {
            int a = userService.addUser(user);
            if(a>0) return "添加用户成功!";
            else return "添加用户失败!";
        }else return "参数缺失!";
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
    public String getCode1 (HttpServletRequest request){
//        Cookie []cookies=request.getCookies();
//        for(Cookie cookie : cookies) {
//            if("code".equals(cookie.getName())) {
//                System.out.println(cookie.getValue());
//            }
//        }
       return code;
    }
}
