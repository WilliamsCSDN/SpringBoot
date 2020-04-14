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
    public String insertkc(String id,String kc){
        if(id != null && kc != null) {
            int a = userKCService.insertkc(id, kc);
            if(a>0) return "添加成功!";
            else return "添加失败!";
        }else return "参数缺失!";
    }

    @RequestMapping("/getuserk")
    public Object  getuserk(String id){
        if(id != null) {
            List<UserKC> userkcs = userKCService.getuserk(id);
            if(userkcs != null) return userkcs;
            else return "该用户暂无收藏课程!";
        }else return "参数缺失!";
    }
    @RequestMapping("/deletekc")
    public String deletekc(String id,String kc){
        if(id != null && kc != null) {
            int a = userKCService.deletekc(id, kc);
            if(a>0) return "删除成功!";
            else return "删除失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/updateSearch1")
    public String updateSearch1(int id){
        if((Integer)id != null) {
            int a = userKCService.updateSearch1(id);
            if(a>0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/updateSearch2")
    public String updateSearch2(int id){
        if((Integer)id != null) {
            int a = userKCService.updateSearch2(id);
            if(a>0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失!";
    }
}
