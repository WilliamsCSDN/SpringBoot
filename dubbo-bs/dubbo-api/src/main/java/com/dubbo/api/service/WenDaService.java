package com.dubbo.api.service;


import com.dubbo.api.model.WenDa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WenDaService {

    public List<WenDa> findAll(String id);
    public List<WenDa> find(String start,String num,String author);
    public int insertwenda(String iid,String name,String content);
    public int insertwenda1(String id,String name,String replyname,String content,String createtime);
    public int deletewenda(String id);
    public int deletewenda1(String id);
    public int deletewenda2(String id);
    public int insertwenda2(String question,String content,String author,String createtime);
    public int countWenDa(int iid);
}
