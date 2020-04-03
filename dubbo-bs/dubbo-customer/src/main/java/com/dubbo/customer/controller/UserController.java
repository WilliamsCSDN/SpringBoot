package com.dubbo.customer.controller;


import com.alibaba.dubbo.common.serialize.Serialization;
import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
public class UserController {
    public String token="";
    @Resource
    UserService userService;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping("/getUser")
    public Object getUser(String username, String password, String token){
       return userService.getUser(username, password, token);
    }
    @RequestMapping("/deleteById")
    public void deleteById(String id){
        userService.deleteById(id);
    }
    @RequestMapping("/findByUsername")
    public User findByUsername(String username){return userService.findByUsername(username);}
    @RequestMapping("/findById")
    public Object findById(String id){
        return userService.findById(id);
    }
    @RequestMapping("/remove")
    public void remove(String token){
        userService.remove(token);
    }
    @RequestMapping("/registerUser")
    public String register(String username,String password,String identity){
        return userService.register(username, password, identity);
    }

    @RequestMapping("/findByName")
    public List<User> findByName(String username, String password){
        return userService.findByName(username, password);
    }
    @RequestMapping("/getpermission")
    public Object getpermission(String iid){
        return userService.getpermission(iid);
    }


    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }
    @RequestMapping("/updateUser1")
    public void updateUser1(User user){
        userService.updateUser1(user);
    }
    @RequestMapping("/updatePassword")
    public void updatePassword(String username,String password,String oldpassword){
        userService.updatePassword(username,password,oldpassword);
    }
    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }


}
