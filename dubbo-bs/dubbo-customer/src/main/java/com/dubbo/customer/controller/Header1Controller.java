package com.dubbo.customer.controller;


import com.dubbo.api.model.Content;
import com.dubbo.api.model.Header1;
import com.dubbo.api.service.Header1Service;
import com.dubbo.customer.filter.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin

public class Header1Controller {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    Header1Service header1Service;

    @GetMapping("/getheader1")
    public Object findAll(){
        List<Header1> header1s=header1Service.findAll();
        if(header1s !=null ){
            logger.info("用户 : {} 获取导航栏内容成功", UserInterceptor.SESSION_USER);
            return header1s;
        }else{
            logger.error("用户 : {} 获取导航栏内容失败",UserInterceptor.SESSION_USER);
            return "无数据";
        }
    }

    @GetMapping("/getbyname")
    public Object findByName(String name){
        if(name != null) {
            List<Content> contents = header1Service.findByName(name);
            if (contents != null) {
                logger.info("用户 : {} 获取名字为{}内容成功", UserInterceptor.SESSION_USER,name);
                return contents;
            } else {
                logger.error("用户 : {} 获取名字为{}内容失败",UserInterceptor.SESSION_USER,name);
                return "无数据";
            }
        }else return "参数缺失";
    }
}
