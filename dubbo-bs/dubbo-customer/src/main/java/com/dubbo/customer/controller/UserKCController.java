package com.dubbo.customer.controller;


import com.dubbo.api.model.UserKC;
import com.dubbo.api.service.UserKCService;
import com.dubbo.customer.filter.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserKCController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    UserKCService userKCService;
    @RequestMapping("/insertkc")
    public String insertkc(String id,String kc){
        if(id != null && kc != null) {
            int a = userKCService.insertkc(id, kc);
            if(a>0) {
                logger.info("用户: {} 收藏课程ID{}成功", UserInterceptor.SESSION_USER,kc);
                return "收藏课程成功";
            }
            else{
                logger.error("用户: {} 收藏课程ID{}失败",UserInterceptor.SESSION_USER,kc);
                return "收藏课程失败";
            }
        }else return "参数缺失";
    }

    @RequestMapping("/getuserk")
    public Object  getuserk(String id){
        if(id != null) {
            List<UserKC> userkcs = userKCService.getuserk(id);
            if(userkcs != null) {
                logger.info("用户: {} 查询用户收藏课程ID{}成功", UserInterceptor.SESSION_USER,id);
                return userkcs;
            }
            else {
                logger.error("用户: {} 查询用户收藏课程ID{}失败",UserInterceptor.SESSION_USER,id);
                return "该用户暂无收藏课程";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/deletekc")
    public String deletekc(String id,String kc){
        if(id != null && kc != null) {
            int a = userKCService.deletekc(id, kc);
            if(a>0) {
                logger.info("用户: {} 取消收藏ID{}成功", UserInterceptor.SESSION_USER,id);
                return "取消收藏成功";
            }
            else {
                logger.error("用户: {} 取消收藏ID{}失败",UserInterceptor.SESSION_USER,id);
                return "取消收藏失败";
            }
        }else return "参数缺失!";
    }
    @RequestMapping("/updateSearch1")
    public String updateSearch1(int id){
        if((Integer)id != null) {
            int a = userKCService.updateSearch1(id);
            if(a>0) {
                logger.info("用户: {} 收藏课程ID{}+1成功", UserInterceptor.SESSION_USER,id);
                return "收藏课程+1成功";
            }
            else {
                logger.error("用户: {} 收藏课程ID{}+1失败失败",UserInterceptor.SESSION_USER,id);
                return "收藏失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updateSearch2")
    public String updateSearch2(int id){
        if((Integer)id != null) {
            int a = userKCService.updateSearch2(id);
            if(a>0) {
                logger.info("用户: {} 收藏课程ID{}-1成功", UserInterceptor.SESSION_USER,id);
                return "收藏课程-1成功!";
            }
            else {
                logger.error("用户: {} 收藏课程ID{}-1失败失败",UserInterceptor.SESSION_USER,id);
                return "收藏失败";
            }
        }else return "参数缺失";
    }
}
