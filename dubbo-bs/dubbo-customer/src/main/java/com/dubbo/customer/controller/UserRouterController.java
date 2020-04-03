package com.dubbo.customer.controller;


import com.dubbo.api.model.UserRouter;
import com.dubbo.api.service.UserRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserRouterController {
    @Resource
    UserRouterService userRouterService;
    @RequestMapping("/insertrouter")
    public void insertrouter(String id, String learnrouter){
        userRouterService.insertrouter(id,learnrouter);
    }
    @RequestMapping("/getuserr")
    public List<UserRouter> getuserr(String id){
        return userRouterService.getuserr(id);
    }
    @RequestMapping("/deleterouter")
    public void deleterouter(String id,String learnrouter){userRouterService.deleterouter(id,learnrouter);}
    @RequestMapping("/updateLearnContent1")
    public void updateLearnContent1(int id){userRouterService.updateLearnContent1(id);}
    @RequestMapping("/updateLearnContent2")
    public void updateLearnContent2(int id){userRouterService.updateLearnContent2(id);}
}
