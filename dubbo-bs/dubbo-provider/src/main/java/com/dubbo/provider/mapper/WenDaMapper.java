package com.dubbo.provider.mapper;


import com.dubbo.api.model.WenDa;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WenDaMapper {
    public List<WenDa> findAll(@Param("id") String id);
    public List<WenDa> find(@Param("start") String start, @Param("num") String num, @Param("author") String author);
    public int insertwenda(@Param("iid") String iid, @Param("name") String name, @Param("content") String content);
    public int insertwenda1(@Param("id") String id, @Param("name") String name, @Param("replyname") String replyname, @Param("content") String content, @Param("createtime") String createtime);
    public int deletewenda(@Param("id") String id);
    public int deletewenda1(@Param("id") String id);
    public int deletewenda2(@Param("id") String id);
    public int insertwenda2(@Param("question") String question, @Param("content") String content, @Param("author") String author, @Param("createtime") String createtime);
    public int countWenDa(@Param("iid") int iid);
}
