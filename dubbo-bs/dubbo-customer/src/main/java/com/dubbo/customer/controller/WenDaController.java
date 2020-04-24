package com.dubbo.customer.controller;


import com.dubbo.api.model.WenDa;
import com.dubbo.api.service.WenDaService;
import com.dubbo.customer.filter.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    WenDaService wenDaService;
    @RequestMapping("wenda")
    public List<WenDa> findAll(String id){
        logger.info("用户: {} 查询所有问答", UserInterceptor.SESSION_USER);
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
        logger.info("用户: {} 查询所有问答分页", UserInterceptor.SESSION_USER);
        return a;
    }
    @RequestMapping("insertwenda")
    public String insertwenda(String iid,String name,String content){
        if(iid != null && name !=null && content != null) {
            int a = wenDaService.insertwenda(iid, name, content);
            if(a>0) {
                logger.info("用户: {} 评论成功", UserInterceptor.SESSION_USER);
                return "评论成功";
            }
            else {
                logger.error("用户: {} 评论失败", UserInterceptor.SESSION_USER);
                return "评论失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("insertwenda1")
    public String insertwenda1(String id,String name,String replyname,String content){
        if(id != null && name !=null && replyname !=null && content != null ) {
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = wenDaService.insertwenda1(id, name, replyname, content, valueOf(simpleDate.format(date)));
            if(a>0) {
                logger.info("用户: {} 回复成功", UserInterceptor.SESSION_USER);
                return "回复成功";
            }
            else {
                logger.error("用户: {} 回复失败", UserInterceptor.SESSION_USER);
                return "回复失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("deletewenda")
    public String deletewenda(String id){
        if(id != null) {
            int a = wenDaService.deletewenda(id);
            if(a>0) {
                logger.info("用户: {} 删除评论ID{}成功", UserInterceptor.SESSION_USER,id);
                return "删除评论成功";
            }
            else {
                logger.error("用户: {} 删除评论ID{}失败", UserInterceptor.SESSION_USER,id);
                return "删除评论失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("insertwenda2")
    public String insertwenda2(String question,String content,String author){
        if(question != null && content != null && author != null ) {
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = wenDaService.insertwenda2(question, content, author, valueOf(simpleDate.format(date)));
            if(a>0) {
                logger.info("用户: {} 添加提问成功", UserInterceptor.SESSION_USER);
                return "添加提问成功";
            }
            else {
                logger.error("用户: {} 添加提问失败", UserInterceptor.SESSION_USER);
                return "添加提问失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("countWenDa")
    public int countWenDa(int iid){
        logger.info("用户: {} 获取评论ID{}数量", UserInterceptor.SESSION_USER,iid);
        return wenDaService.countWenDa(iid);
    }
}
