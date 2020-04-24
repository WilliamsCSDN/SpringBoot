package com.dubbo.customer.controller;


import com.dubbo.api.model.Search;
import com.dubbo.api.service.SearchService;
import com.dubbo.customer.filter.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class SearchController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    SearchService searchService;

    @RequestMapping("/search")
    public Object findAll(HttpServletResponse httpServletResponse,String a, String start, String num){
        if(a==null||a=="") {
            logger.info("用户: {} 查询所有课程", UserInterceptor.SESSION_USER);
            return searchService.search2(start,num);
        }
        else {
            List<Search> searches = searchService.findAll(a, start, num);
            if(searches != null) {
                logger.info("用户: {} 查询课程关键字为{}成功", UserInterceptor.SESSION_USER,a);
                return searches;
            }
            else {
                logger.error("用户: {} 查询课程关键字为{}失败",UserInterceptor.SESSION_USER,a);
                return "课程不存在";
            }
        }
    }

    @RequestMapping("/search1")
    public Object findAll1(String start,String num){
        if(start != null && num != null) {
            logger.info("用户: {} 查询所有课程分页", UserInterceptor.SESSION_USER);
            return searchService.findAll1(start, num);
        }else return "参数缺失";
    }

    @RequestMapping("/searchById")
    public Object findById(String id,String author){
        List<Search> searches = searchService.findById(id,author);
        if(searches != null) {
            logger.info("用户: {} 查询课程ID{}成功", UserInterceptor.SESSION_USER,id);
            return searches;
        }
        else {
            logger.error("用户: {} 查询课程ID{}失败",UserInterceptor.SESSION_USER,id);
            return "课程不存在";
        }
    }
    @RequestMapping("/redisGetSearch")
    public Object search1(String a,String b) {
        return searchService.search1(a,b);
    }

    @RequestMapping("/updateimg")
    public Boolean updateimg(Search search){
        if(search !=null) {
            logger.info("用户: {} 修改ID{}图片成功", UserInterceptor.SESSION_USER,search.getId());
            return searchService.updateimg(search);
        }
        else {
            logger.error("用户: {} 修改ID{}图片失败",UserInterceptor.SESSION_USER,search.getId());
            return false;
        }
    }
    @RequestMapping("/insertlesson")
    public String insertlesson(Search search){
        if(search != null && (Integer)search.getId() != null) {
            int a = searchService.insertlesson(search);
            if (a > 0) {
                logger.info("用户: {} 添加课程成功", UserInterceptor.SESSION_USER);
                return "添加课程成功";
            }
            else {
                logger.error("用户: {} 添加课程失败",UserInterceptor.SESSION_USER);
                return "添加课程失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/deletelesson")
    public String deletelesson(String id){
        if(id != null) {
            int a = searchService.deletelesson(id);
            if(a>0) {
                logger.info("用户: {} 删除课程ID{}成功", UserInterceptor.SESSION_USER,id);
                return "删除课程成功";
            }
            else {
                logger.error("用户: {} 删除课程ID{}失败",UserInterceptor.SESSION_USER,id);
                return "删除课程失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/getHotsearch")
    public Object getHotsearch(){
        List<Search> searches = searchService.getHotsearch();
        if(searches != null) {
            logger.info("用户: {} 查询热门课程成功", UserInterceptor.SESSION_USER);
            return searches;
        }
        else {
            logger.error("用户: {} 查询热门课程失败",UserInterceptor.SESSION_USER);
            return "课程不存在";
        }
    }

    @RequestMapping("/search2")
    public Object search2(int url){
        if((Integer)url != null) {
            List<Search> searches = searchService.search2(url);
            if(searches != null) {
                logger.info("用户: {} 查询课程url{}成功", UserInterceptor.SESSION_USER,url);
                return searches;
            }
            else {
                logger.error("用户: {} 查询课程url{}失败",UserInterceptor.SESSION_USER,url);
                return "课程不存在";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/selectBestId")
    public int selectBestId(){ return searchService.selectBestId();}
    @RequestMapping("/selectBestId1")
    public int selectBestId1(){ return searchService.selectBestId1();}
}
