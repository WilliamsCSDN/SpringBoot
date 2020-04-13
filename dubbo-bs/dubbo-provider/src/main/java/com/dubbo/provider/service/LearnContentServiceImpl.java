package com.dubbo.provider.service;


import com.dubbo.api.model.LearnContent;
import com.dubbo.api.model.LearnRouter1;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.LearnContentService;
import com.dubbo.provider.mapper.LearnContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LearnContentServiceImpl implements LearnContentService {
    @Resource
    LearnContentMapper learnContentMapper;

    public List<LearnContent> selectAll(String id, String start, String num){
        return learnContentMapper.selectAll(id,start,num);
    }
    public List<LearnContent> selectHot(String id){ return learnContentMapper.selectHot(id);}
    public List<LearnRouter1> getrouterbyid(String id) {
        if(id != null) return  learnContentMapper.getrouterbyid(id);
        else return null;
    }
    public List<LearnContent> getlearncontent(String id,String author){return learnContentMapper.getlearncontent(id,author);}
    public void deletelearncontent(String id){
        if(id!=null) learnContentMapper.deletelearncontent(id);
    }
    public void insertlearncontent(LearnContent learnContent){
        if(learnContent != null)
        learnContentMapper.insertlearncontent(learnContent);
    }
    public void updatelearncontent(LearnContent learnContent){
        if(learnContent != null && (Integer)learnContent.getId() != null)
           learnContentMapper.updatelearncontent(learnContent);
    }
    public void insertlearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null && (Integer)learnRouter1.getIid() != null)
        learnContentMapper.insertlearnrouter(learnRouter1);
    }
    public void deletelearnrouter(String id){
        if(id != null)
           learnContentMapper.deletelearnrouter(id);
    }
    public void updatelearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null)
           learnContentMapper.updatelearnrouter(learnRouter1);
    }
    public void updatelearnrouter1(LearnRouter1 learnRouter1){
        if(learnRouter1 != null)
        learnContentMapper.updatelearnrouter1(learnRouter1);
    }


}
