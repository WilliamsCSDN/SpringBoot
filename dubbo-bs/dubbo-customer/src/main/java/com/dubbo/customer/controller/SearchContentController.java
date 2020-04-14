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
    public  Object findAll(String id){
//        for(SearchContent a: searchContentService.findAll(id))
//        System.out.println(a.id);
        List<SearchContent> searchContents = searchContentService.findAll(id);
        if(searchContents != null) return searchContents;
        else return "找不到课程内容!";
    }
    @RequestMapping("/insertzj")
    public String insertzj(String iid,String zj,String title){
        if(iid != null && zj != null && title != null) {
            int a = searchContentService.insertzj(iid, zj, title);
            if (a > 0) return "添加成功!";
            else return "添加失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/insertzj1")
    public String insertzj1(SearchContent1 searchContent1){
        if(searchContent1 !=null) {
            int a = searchContentService.insertzj1(searchContent1);
            if (a > 0) return "添加成功!";
            else return "添加失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatezj")
    public String updatezj(String id,String title){
        if(id != null && title != null) {
            int a = searchContentService.updatezj(id, title);
            if (a > 0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatezj1")
    public String updatezj1(String id,String title,String url){
        if(id != null && title != null && url != null) {
            int a = searchContentService.updatezj1(id, title, url);
            if (a > 0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失！";
    }

    @RequestMapping("/deletezj1")
    public String deletezj1(String id,String iid,int zj){
        if(id != null && iid != null && (Integer)zj != null) {
            int a = searchContentService.deletezj1(id, iid, zj);
            if (a > 0) return "删除成功!";
            else return "删除失败!";
        }else return "参数缺失！";
    }

    @RequestMapping("/deletesearchcontent")
    public String deletesearchcontent(String iid,String zj){
        if(iid != null && zj != null) {
            int a = searchContentService.deletesearchcontent(iid, zj);
            if (a > 0) return "删除成功!";
            else return "删除失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatesearchcontent")
    public String updatesearchcontent(String id,String zj){
        if(id != null && zj != null) {
            int a = searchContentService.updatesearchcontent(id, zj);
            if (a > 0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatesearchcontent1")
    public String updatesearchcontent1(String id,String zj,String zjj){
        if(id != null && zj != null && zjj != null) {
            int a = searchContentService.updatesearchcontent1(id, zj, zjj);
            if (a > 0) return "修改成功!";
            else return "修改失败!";
        }else return "参数缺失！";
    }
}
