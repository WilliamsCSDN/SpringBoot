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
            System.out.println("redis获取数据");
            return searchService.search2(start,num);
        }
        else return searchService.findAll(a,start,num);

    }

    @RequestMapping("/search1")
    public Object findAll1(String start,String num){return searchService.findAll1(start,num);}

    @RequestMapping("/searchById")
    public Object findById(String id,String author){
        return searchService.findById(id,author);
    }
    @RequestMapping("/redisGetSearch")
    public Object search1(String a,String b) {
        return searchService.search1(a,b);
    }

    @RequestMapping("/updateimg")
    public void updateimg(Search search){
        searchService.updateimg(search);
    }
    @RequestMapping("/insertlesson")
    public void insertlesson(Search search){
        searchService.insertlesson(search);
    }
    @RequestMapping("/deletelesson")
    public void deletelesson(String id){
        searchService.deletelesson(id);
    }
    @RequestMapping("/getHotsearch")
    public List<Search> getHotsearch(){ return  searchService.getHotsearch();}

    @RequestMapping("/search2")
    public List<Search> search2(int url){return searchService.search2(url);}
    @RequestMapping("/selectBestId")
    public int selectBestId(){return searchService.selectBestId();}
    @RequestMapping("/selectBestId1")
    public int selectBestId1(){return searchService.selectBestId1();}
}
