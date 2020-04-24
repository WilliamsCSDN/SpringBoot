package com.dubbo.customer.controller;


import com.dubbo.api.model.Comment;
import com.dubbo.api.service.CommentService;
import com.dubbo.customer.filter.UserInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

@RestController
@CrossOrigin
public class CommentController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    CommentService commentService;

    @RequestMapping("/comment")
    public Object findAll(String articleid){
        if(articleid != null) {
            List<Comment> comments = commentService.findAll(articleid);
            if (comments != null && !comments.isEmpty()) {
                logger.info("用户 : {} 查询课程评论ID{}成功", UserInterceptor.SESSION_USER,articleid);
                return commentService.findAll(articleid);
            } else {
                logger.error("用户 : {} 课程ID{}没有评论", UserInterceptor.SESSION_USER,articleid);
                return "该课程没有评论";
            }
        }else {
            return "参数缺失";
        }
    }
    @RequestMapping("/insertcomment")
    public String insertcomment(String articleid,String name,String content,String state){
        if(articleid!=null&&name!=null&&content!=null&&state==null) {
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = commentService.insertcomment(articleid, name, content, valueOf(simpleDate.format(date)), state);
            if (a > 0) {
                logger.info("用户 : {} 添加评论成功", UserInterceptor.SESSION_USER);
                return "添加评论成功";
            }
            else {
                logger.error("用户 : {} 添加评论失败", UserInterceptor.SESSION_USER);
                return "添加评论失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/insertcomment1")
    public String insertcomment1(String comment_id,String name,String replyname,String content,String prase_count){
        if(comment_id!=null&&name!=null&&replyname!=null&&content!=null&&prase_count!=null){
            Date date = new Date();
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int a = commentService.insertcomment1(comment_id, name, replyname, content, prase_count, valueOf(simpleDate.format(date)));
            if (a > 0) {
                logger.info("用户 : {} 添加回复成功", UserInterceptor.SESSION_USER);
                return "添加回复成功";
            }
            else {
                logger.error("用户 : {} 添加回复失败", UserInterceptor.SESSION_USER);
                return "添加回复失败";
            }
        }else return "参数缺失";
    }
    @RequestMapping("/updatesh")
    public boolean updatesh(String id,String state){
        if(id!=null && state!=null) {
            logger.info("用户 : {} 评论ID{}审核成功", UserInterceptor.SESSION_USER,id);
            return commentService.updatesh(id, state);
        }else {
            logger.error("用户 : {} 评论ID{}审核失败", UserInterceptor.SESSION_USER,id);
            return false;
        }
    }
    @RequestMapping("/deletecomment")
    public String deletecomment(String id){
        if(id != null) {
            int a = commentService.deletecomment(id);
            if (a > 0) {
                logger.info("用户 : {} 删除评论ID{}成功", UserInterceptor.SESSION_USER,id);
                return "删除评论成功";
            }
            else {
                logger.error("用户 : {} 删除评论ID{}失败", UserInterceptor.SESSION_USER,id);
                return "删除评论失败";
            }
        }else return "参数缺失";
    }
}
