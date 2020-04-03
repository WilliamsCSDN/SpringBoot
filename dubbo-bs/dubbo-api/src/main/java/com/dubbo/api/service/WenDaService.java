package com.dubbo.api.service;


import com.dubbo.api.model.WenDa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WenDaService {

    public List<WenDa> findAll(String id);
    public List<WenDa> find(String start,String num,String author);
    public void insertwenda(String iid,String name,String content);
    public void insertwenda1(String id,String name,String replyname,String content,String createtime);
    public void deletewenda(String id);
    public void deletewenda1(String id);
    public void deletewenda2(String id);
    public void insertwenda2(String question,String content,String author,String createtime);
    public int countWenDa(int iid);
}
