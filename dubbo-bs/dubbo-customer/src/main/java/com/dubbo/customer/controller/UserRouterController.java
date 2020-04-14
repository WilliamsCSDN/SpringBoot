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
    public String insertrouter(String id, String learnrouter){
        if(id != null && learnrouter != null) {
            int a = userRouterService.insertrouter(id, learnrouter);
            if(a>0) return "添加成功!";
            else return "添加失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/getuserr")
    public Object getuserr(String id){
        if(id != null) {
            List<UserRouter> userRouters = userRouterService.getuserr(id);
            if(userRouters != null) return userRouters;
            else return "用户暂无收藏线路!";
        }else return "参数缺失!";
    }
    @RequestMapping("/deleterouter")
    public String deleterouter(String id,String learnrouter){
        if(id != null && learnrouter != null) {
            int a = userRouterService.deleterouter(id, learnrouter);
            if(a>0) return "删除成功!";
            else return "删除失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/updateLearnContent1")
    public String updateLearnContent1(int id){
        if((Integer)id != null) {
            int a = userRouterService.updateLearnContent1(id);
            if(a>0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/updateLearnContent2")
    public String updateLearnContent2(int id){
        if((Integer)id != null) {
            int a = userRouterService.updateLearnContent2(id);
            if(a>0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失!";
    }
}
