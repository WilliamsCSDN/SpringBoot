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
    public List<Header1> findAll(){
        return header1Service.findAll();
    }

    @GetMapping("/getbyname")
    public List<Content> findByName(String name){return header1Service.findByName(name);}



}
