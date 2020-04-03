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
    public List<WenDa> findAll(String id){
        return wenDaService.findAll(id);
    }
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
    public void insertwenda(String iid,String name,String content){
        wenDaService.insertwenda(iid,name,content);}
    @RequestMapping("insertwenda1")
    public void insertwenda1(String id,String name,String replyname,String content){
        Date date=new Date();
        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wenDaService.insertwenda1(id,name,replyname,content,valueOf(simpleDate.format(date)));
    }
    @RequestMapping("deletewenda")
    public void deletewenda(String id){
        wenDaService.deletewenda(id);
    }
    @RequestMapping("insertwenda2")
    public void insertwenda2(String question,String content,String author){
        Date date=new Date();
        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        wenDaService.insertwenda2(question,content,author,valueOf(simpleDate.format(date)));
    }
    @RequestMapping("countWenDa")
    public int countWenDa(int iid){return wenDaService.countWenDa(iid);}
}
