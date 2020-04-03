package com.dubbo.customer.controller;


import com.dubbo.api.model.UserKC;
import com.dubbo.api.service.UserKCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserKCController {
    @Resource
    UserKCService userKCService;
    @RequestMapping("/insertkc")
    public void insertkc(String id,String kc){userKCService.insertkc(id,kc);}

    @RequestMapping("/getuserk")
    public List<UserKC> getuserk(String id){
        return userKCService.getuserk(id);
    }
    @RequestMapping("/deletekc")
    public void deletekc(String id,String kc){ userKCService.deletekc(id,kc);}
    @RequestMapping("/updateSearch1")
    public void updateSearch1(int id){userKCService.updateSearch1(id);}
    @RequestMapping("/updateSearch2")
    public void updateSearch2(int id){userKCService.updateSearch2(id);}
}
