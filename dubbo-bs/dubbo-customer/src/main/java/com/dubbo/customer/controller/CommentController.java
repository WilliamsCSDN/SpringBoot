package com.dubbo.customer.controller;


import com.dubbo.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

@RestController
@CrossOrigin
public class CommentController {
    @Resource
    CommentService commentService;
    @RequestMapping("/comment")
    public Object findAll(String articleid){

        return commentService.findAll(articleid);
    }
    @RequestMapping("/insertcomment")
    public void insertcomment(String articleid,String name,String content,String state){
        Date date=new Date();
        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            commentService.insertcomment(articleid,name,content, valueOf(simpleDate.format(date)),state);

    }
    @RequestMapping("/insertcomment1")
    public void insertcomment1(String comment_id,String name,String replyname,String content,String prase_count){
        Date date=new Date();
        SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        commentService.insertcomment1(comment_id,name,replyname,content,prase_count,valueOf(simpleDate.format(date)));
    }
    @RequestMapping("/updatesh")
    public void updatesh(String id,String state){
        commentService.updatesh(id,state);
    }
    @RequestMapping("/deletecomment")
    public void deletecomment(String id){
        commentService.deletecomment(id);
    }
}
