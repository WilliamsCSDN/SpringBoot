package com.dubbo.customer.controller;


import com.dubbo.api.model.Search;
import com.dubbo.api.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class SearchController {
    @Resource
    SearchService searchService;
    @RequestMapping("/search")
    public Object findAll(String a,String start,String num){
        if(a==null||a=="") {
            return searchService.search2(start,num);
        }
        else {
            List<Search> searches = searchService.findAll(a, start, num);
            if(searches != null) return searches;
            else return "课程不存在!";
        }
    }

    @RequestMapping("/search1")
    public Object findAll1(String start,String num){
        if(start != null && num != null) {
            return searchService.findAll1(start, num);
        }else return "参数缺失!";
    }

    @RequestMapping("/searchById")
    public Object findById(String id,String author){
        List<Search> searches = searchService.findById(id,author);
        if(searches != null) return searches;
        else return "课程不存在!";
    }
    @RequestMapping("/redisGetSearch")
    public Object search1(String a,String b) {
        return searchService.search1(a,b);
    }

    @RequestMapping("/updateimg")
    public Boolean updateimg(Search search){
        if(search !=null) return searchService.updateimg(search);
        else return false;
    }
    @RequestMapping("/insertlesson")
    public String insertlesson(Search search){
        if(search != null && (Integer)search.getId() != null) {
            int a = searchService.insertlesson(search);
            if (a > 0) return "添加课程成功!";
            else return "添加课程失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("/deletelesson")
    public String deletelesson(String id){
        if(id != null) {
            int a = searchService.deletelesson(id);
            if(a>0) return "删除课程成功!";
            else return "删除课程失败";
        }else return "参数缺失!";
    }
    @RequestMapping("/getHotsearch")
    public Object getHotsearch(){
        List<Search> searches = searchService.getHotsearch();
        if(searches != null) return searches;
        else return "课程不存在!";
    }

    @RequestMapping("/search2")
    public Object search2(int url){
        if((Integer)url != null) {
            List<Search> searches = searchService.search2(url);
            if(searches != null) return searches;
            else return "课程不存在!";
        }else return "参数缺失!";
    }
    @RequestMapping("/selectBestId")
    public int selectBestId(){ return searchService.selectBestId();}
    @RequestMapping("/selectBestId1")
    public int selectBestId1(){ return searchService.selectBestId1();}
}
