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
    public List<LearnRouter1> getrouterbyid(String id) {return  learnContentMapper.getrouterbyid(id);}
    public List<LearnContent> getlearncontent(String id,String author){return learnContentMapper.getlearncontent(id,author);}
    public void deletelearncontent(String id){learnContentMapper.deletelearncontent(id);}
    public void insertlearncontent(LearnContent learnContent){learnContentMapper.insertlearncontent(learnContent);}
    public void updatelearncontent(LearnContent learnContent){
        learnContentMapper.updatelearncontent(learnContent);
    }
    public void insertlearnrouter(LearnRouter1 learnRouter1){learnContentMapper.insertlearnrouter(learnRouter1);}
    public void deletelearnrouter(String id){learnContentMapper.deletelearnrouter(id);}
    public void updatelearnrouter(LearnRouter1 learnRouter1){learnContentMapper.updatelearnrouter(learnRouter1);}
    public void updatelearnrouter1(LearnRouter1 learnRouter1){learnContentMapper.updatelearnrouter1(learnRouter1);}


}
