package com.dubbo.provider.service;

import com.dubbo.api.model.Comment;
import com.dubbo.api.service.CommentService;

import com.dubbo.provider.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Resource
    CommentMapper commentMapper;
    public List<Comment> findAll(String articleid){return commentMapper.findAll(articleid);}
    public void insertcomment(String articleid, String name, String content, String createtime, String state){ commentMapper.insertcomment(articleid,name,content,createtime,state);}
    public void insertcomment1( String comment_id,String name,String replyname,String content,String prase_count,String createtime){commentMapper.insertcomment1(comment_id,name,replyname,content,prase_count,createtime);}
    public void updatesh(String id,String state){commentMapper.updatesh(id,state);}

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void deletecomment(String id){
        commentMapper.deletecomment(id);
        commentMapper.deletecomment1(id);
    }

}
