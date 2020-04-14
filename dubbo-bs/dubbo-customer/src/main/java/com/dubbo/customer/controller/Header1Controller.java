package com.dubbo.customer.controller;


import com.dubbo.api.model.Content;
import com.dubbo.api.model.Header1;
import com.dubbo.api.service.Header1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin

public class Header1Controller {
    @Resource
    Header1Service header1Service;

    @GetMapping("/getheader1")
    public Object findAll(){
        List<Header1> header1s=header1Service.findAll();
        if(header1s !=null ){
            return header1s;
        }else{
            return "无数据!";
        }
    }

    @GetMapping("/getbyname")
    public Object findByName(String name){
        if(name != null) {
            List<Content> contents = header1Service.findByName(name);
            if (contents != null) {
                return contents;
            } else {
                return "无数据!";
            }
        }else return "参数缺失！";
    }
}
