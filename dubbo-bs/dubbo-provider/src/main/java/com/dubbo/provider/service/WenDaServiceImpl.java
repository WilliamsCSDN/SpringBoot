package com.dubbo.provider.service;


import com.dubbo.api.model.WenDa;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.WenDaService;
import com.dubbo.provider.mapper.WenDaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WenDaServiceImpl implements WenDaService {
    @Resource
    WenDaMapper wenDaMapper;
    public List<WenDa> findAll(String id){return wenDaMapper.findAll(id);}
    public List<WenDa> find(String start,String num,String author){return wenDaMapper.find(start, num,author);}
    public void insertwenda(String iid,String name,String content){wenDaMapper.insertwenda(iid,name,content);}
    public void insertwenda1(String id,String name,String replyname,String content,String createtime){wenDaMapper.insertwenda1(id,name,replyname,content,createtime);}
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void deletewenda(String id){
        wenDaMapper.deletewenda(id);
        deletewenda1(id);
        deletewenda2(id);
    }
    public void deletewenda1(String id){wenDaMapper.deletewenda1(id);}
    public void deletewenda2(String id){wenDaMapper.deletewenda2(id);}
    public void insertwenda2(String question,String content,String author,String createtime){wenDaMapper.insertwenda2(question,content,author,createtime);}
    public int countWenDa(int iid){return wenDaMapper.countWenDa(iid);}
}