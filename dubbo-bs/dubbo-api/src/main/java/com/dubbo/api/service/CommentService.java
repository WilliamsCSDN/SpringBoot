package com.dubbo.api.service;


import com.dubbo.api.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    public List<Comment> findAll(String articleid);
    public void insertcomment(String articleid, String name, String content, String createtime, String state);
    public void insertcomment1( String comment_id,String name,String replyname,String content,String prase_count,String createtime);
    public boolean updatesh(String id,String state);
    public void deletecomment(String id);
}