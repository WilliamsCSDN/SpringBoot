package com.dubbo.provider.mapper;


import com.dubbo.api.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<Comment> findAll(@Param("articleid") String articleid);
    public int insertcomment(@Param("articleid") String articleid, @Param("name") String name, @Param("content") String content, @Param("createtime") String createtime, @Param("state") String state);
    public int insertcomment1(@Param("comment_id") String comment_id, @Param("name") String name, @Param("replyname") String replyname, @Param("content") String content, @Param("prase_count") String prase_count, @Param("createtime") String createtime);
    public boolean updatesh(@Param("id") String id, @Param("state") String state);
    public int deletecomment(@Param("id") String id);
    public int deletecomment1(@Param("id") String id);
}
