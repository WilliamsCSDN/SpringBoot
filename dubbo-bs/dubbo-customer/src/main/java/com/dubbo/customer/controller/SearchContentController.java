package com.dubbo.customer.controller;


import com.dubbo.api.model.SearchContent;
import com.dubbo.api.model.SearchContent1;
import com.dubbo.api.service.SearchContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class SearchContentController {
    @Resource
    SearchContentService searchContentService;
    @RequestMapping("/searchcontent")
    public  List<SearchContent> findAll(String id){
//        for(SearchContent a: searchContentService.findAll(id))
//        System.out.println(a.id);
        return searchContentService.findAll(id);
    }
    @RequestMapping("/insertzj")
    public void insertzj(String iid,String zj,String title){
        searchContentService.insertzj(iid,zj,title);
    }
    @RequestMapping("/insertzj1")
    public void insertzj1(SearchContent1 searchContent1){
        searchContentService.insertzj1(searchContent1);
    }
    @RequestMapping("/updatezj")
    public void updatezj(String id,String title){ searchContentService.updatezj(id,title); }
    @RequestMapping("/updatezj1")
    public void updatezj1(String id,String title,String url){ searchContentService.updatezj1(id,title,url); }

    @RequestMapping("/deletezj1")
    public void deletezj1(String id,String iid,int zj){
        searchContentService.deletezj1(id,iid,zj);
    }

    @RequestMapping("/deletesearchcontent")
    public void deletesearchcontent(String iid,String zj){searchContentService.deletesearchcontent(iid,zj);}
    @RequestMapping("/updatesearchcontent")
    public void updatesearchcontent(String id,String zj){searchContentService.updatesearchcontent(id,zj);}
    @RequestMapping("/updatesearchcontent1")
    public void updatesearchcontent1(String id,String zj,String zjj){searchContentService.updatesearchcontent1(id,zj,zjj);}
}
