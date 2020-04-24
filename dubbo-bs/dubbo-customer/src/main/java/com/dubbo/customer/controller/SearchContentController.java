package com.dubbo.customer.controller;


import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import com.dubbo.api.service.SearchContentService;
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
public class SearchContentController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    SearchContentService searchContentService;
    @RequestMapping("/searchcontent")
    public  Object findAll(String id){

        List<SearchContent> searchContents = searchContentService.findAll(id);
        if(searchContents != null) {
            logger.info("用户: {} 查询课程内容ID{}成功", UserInterceptor.SESSION_USER,id);
            return searchContents;
        }
        else {
            logger.error("用户: {} 查询课程内容ID{}失败",UserInterceptor.SESSION_USER,id);
            return "找不到课程内容";
        }
    }
    @RequestMapping("/insertzj")
    public String insertzj(String iid,String zj,String title){
        if(iid != null && zj != null && title != null) {
            int a = searchContentService.insertzj(iid, zj, title);
            if (a > 0) {
                logger.info("用户: {} 添加课程章成功", UserInterceptor.SESSION_USER);
                return "添加课程章成功";
            }
            else {
                logger.error("用户: {} 添加课程章失败",UserInterceptor.SESSION_USER);
                return "添加课程章失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/insertzj1")
    public String insertzj1(SearchContent1 searchContent1){
        if(searchContent1 !=null) {
            int a = searchContentService.insertzj1(searchContent1);
            if (a > 0) {
                logger.info("用户: {} 添加课程节成功", UserInterceptor.SESSION_USER);
                return "添加课程节成功";
            }
            else {
                logger.error("用户: {} 添加课程节失败",UserInterceptor.SESSION_USER);
                return "添加课程节失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updatezj")
    public String updatezj(String id,String title){
        if(id != null && title != null) {
            int a = searchContentService.updatezj(id, title);
            if (a > 0) {
                logger.info("用户: {} 修改课程章ID{}成功", UserInterceptor.SESSION_USER,id);
                return "修改课程章成功";
            }
            else {
                logger.error("用户: {} 修改课程章ID{}失败",UserInterceptor.SESSION_USER,id);
                return "修改课程章失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updatezj1")
    public String updatezj1(String id,String title,String url){
        if(id != null && title != null && url != null) {
            int a = searchContentService.updatezj1(id, title, url);
            if (a > 0) {
                logger.info("用户: {} 修改课程节ID{}成功", UserInterceptor.SESSION_USER,id);
                return "修改课程节成功";
            }
            else {
                logger.error("用户: {} 修改课程节ID{}失败",UserInterceptor.SESSION_USER,id);
                return "修改课程节失败";
            }
        }else return "参数缺失";
    }

    @RequestMapping("/deletezj1")
    public String deletezj1(String id,String iid,int zj){
        if(id != null && iid != null && (Integer)zj != null) {
            int a = searchContentService.deletezj1(id, iid, zj);
            if (a > 0) {
                logger.info("用户: {} 删除课程节ID{}成功", UserInterceptor.SESSION_USER,id);
                return "删除课程节成功";
            }
            else {
                logger.error("用户: {} 删除课程节ID{}失败",UserInterceptor.SESSION_USER,id);
                return "删除课程节失败";
            }
        }else return "参数缺失";
    }

    @RequestMapping("/deletesearchcontent")
    public String deletesearchcontent(String iid,String zj){
        if(iid != null && zj != null) {
            int a = searchContentService.deletesearchcontent(iid, zj);
            if (a > 0) {
                logger.info("用户: {} 删除课程章ID{}成功", UserInterceptor.SESSION_USER,iid);
                return "删除课程章成功";
            }
            else {
                logger.error("用户: {} 删除课程章ID{}失败",UserInterceptor.SESSION_USER,iid);
                return "删除课程章失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updatesearchcontent")
    public String updatesearchcontent(String id,String zj){
        if(id != null && zj != null) {
            int a = searchContentService.updatesearchcontent(id, zj);
            if (a > 0) {
                logger.info("用户: {} 修改课程章ID{}成功", UserInterceptor.SESSION_USER,id);
                return "修改课程章成功";
            }
            else {
                logger.error("用户: {} 修改课程章ID{}失败",UserInterceptor.SESSION_USER,id);
                return "修改课程章失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updatesearchcontent1")
    public String updatesearchcontent1(String id,String zj,String zjj){
        if(id != null && zj != null && zjj != null) {
            int a = searchContentService.updatesearchcontent1(id, zj, zjj);
            if (a > 0) {
                logger.info("用户: {} 修改课程节ID{}成功", UserInterceptor.SESSION_USER,id);
                return "修改课程节成功";
            }
            else {
                logger.error("用户: {} 修改课程节ID{}失败",UserInterceptor.SESSION_USER,id);
                return "修改课程节失败";
            }
        }else return "参数缺失";
    }
}
