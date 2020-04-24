package com.dubbo.customer.controller;


import com.dubbo.api.model.UserRouter;
import com.dubbo.api.service.UserRouterService;
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
public class UserRouterController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    UserRouterService userRouterService;
    @RequestMapping("/insertrouter")
    public String insertrouter(String id, String learnrouter){
        if(id != null && learnrouter != null) {
            int a = userRouterService.insertrouter(id, learnrouter);
            if(a>0) {
                logger.info("用户: {} 收藏线路ID{}成功", UserInterceptor.SESSION_USER,learnrouter);
                return "收藏线路成功";
            }
            else {
                logger.error("用户: {} 收藏线路ID{}失败", UserInterceptor.SESSION_USER,learnrouter);
                return "收藏线路失败";
            }
        }else return "参数缺失!";
    }
    @RequestMapping("/getuserr")
    public Object getuserr(String id){
        if(id != null) {
            List<UserRouter> userRouters = userRouterService.getuserr(id);
            if(userRouters != null) {
                logger.info("用户: {} 查询用户收藏线路成功", UserInterceptor.SESSION_USER);
                return userRouters;
            }
            else {
                logger.error("用户: {} 查询用户收藏线路失败", UserInterceptor.SESSION_USER);
                return "用户暂无收藏线路";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/deleterouter")
    public String deleterouter(String id,String learnrouter){
        if(id != null && learnrouter != null) {
            int a = userRouterService.deleterouter(id, learnrouter);
            if(a>0) {
                logger.info("用户: {} 取消收藏线路ID{}成功", UserInterceptor.SESSION_USER,learnrouter);
                return "取消线路收藏成功";
            }
            else {
                logger.error("用户: {} 取消收藏线路ID{}失败", UserInterceptor.SESSION_USER,learnrouter);
                return "取消线路收藏失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updateLearnContent1")
    public String updateLearnContent1(int id){
        if((Integer)id != null) {
            int a = userRouterService.updateLearnContent1(id);
            if(a>0) {
                logger.info("用户: {} 收藏线路ID{}+1成功", UserInterceptor.SESSION_USER,id);
                return "收藏+1成功";
            }
            else {
                logger.error("用户: {} 收藏线路ID{}+1失败", UserInterceptor.SESSION_USER,id);
                return "收藏线路+1失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updateLearnContent2")
    public String updateLearnContent2(int id){
        if((Integer)id != null) {
            int a = userRouterService.updateLearnContent2(id);
            if(a>0) {
                logger.info("用户: {} 收藏线路ID{}-1成功", UserInterceptor.SESSION_USER,id);
                return "收藏线路-1成功";
            }
            else {
                logger.error("用户: {} 收藏线路ID{}-1失败", UserInterceptor.SESSION_USER,id);
                return "收藏线路-1失败";
            }
        }else return "参数缺失";
    }
}
