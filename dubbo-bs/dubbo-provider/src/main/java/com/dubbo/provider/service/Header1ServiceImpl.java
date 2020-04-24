package com.dubbo.provider.service;


import com.dubbo.api.model.Content;
import com.dubbo.api.model.Header1;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.Header1Service;
import com.dubbo.provider.mapper.Header1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Header1ServiceImpl implements Header1Service {
    @Resource
    Header1Mapper header1Mapper;
    public List<Header1> findAll(){
       return header1Mapper.findAll();

    }
    public List<Content> findByName(String name){
        if(name != null) return header1Mapper.findByName(name);
        else return null;
    }

}
