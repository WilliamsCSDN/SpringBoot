package com.dubbo.customer.controller;


import com.dubbo.api.model.WenDa;
import com.dubbo.api.service.WenDaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

@RestController
@CrossOrigin
public class WenDaController {
    @Resource
    WenDaService wenDaService;
    @RequestMapping("wenda")
    public List<WenDa> findAll(String id){ return wenDaService.findAll(id); }
    @RequestMapping("wenda1")
    public List<WenDa> find(String start,String num,String author){
//        return wenDaService.find(start,num,author);
        List<WenDa> a=new ArrayList<>();
        for(WenDa wenDa:wenDaService.find(start,num,author)) {
            wenDa.setCountwenda(countWenDa((int) wenDa.getId()));
            a.add(wenDa);
        }
        return a;
    }
    @RequestMapping("insertwenda")
    public String insertwenda(String iid,String name,String content){
        if(iid != null && name !=null && content != null) {
            int a = wenDaService.insertwenda(iid, name, content);
            if(a>0) return "评论成功!";
            else return "评论失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("insertwenda1")
    public String insertwenda1(String id,String name,String replyname,String content){
        if(id != null && name !=null && replyname !=null && content != null ) {
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = wenDaService.insertwenda1(id, name, replyname, content, valueOf(simpleDate.format(date)));
            if(a>0) return "回复成功!";
            else return "回复失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("deletewenda")
    public String deletewenda(String id){
        if(id != null) {
            int a = wenDaService.deletewenda(id);
            if(a>0) return "删除评论成功!";
            else return "删除评论失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("insertwenda2")
    public String insertwenda2(String question,String content,String author){
        if(question != null && content != null && author != null ) {
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = wenDaService.insertwenda2(question, content, author, valueOf(simpleDate.format(date)));
            if(a>0) return "添加提问成功!";
            else return "添加提问失败!";
        }else return "参数缺失!";
    }
    @RequestMapping("countWenDa")
    public int countWenDa(int iid){
            return wenDaService.countWenDa(iid);
    }
}
