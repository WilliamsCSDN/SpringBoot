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
    public List<LearnContent> getlearncontent(String id,String author){
        return learnContentMapper.getlearncontent(id,author);
    }
    public int deletelearncontent(String id){
        if(id!=null) return learnContentMapper.deletelearncontent(id);
        else return 0;
    }
    public int insertlearncontent(LearnContent learnContent){
        if(learnContent != null) return learnContentMapper.insertlearncontent(learnContent);
        else return 0;
    }
    public int updatelearncontent(LearnContent learnContent){
        if(learnContent != null && (Integer)learnContent.getId() != null)
          return learnContentMapper.updatelearncontent(learnContent);
        else return 0;
    }
    public int insertlearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null && (Integer)learnRouter1.getIid() != null)
        return   learnContentMapper.insertlearnrouter(learnRouter1);
        else return 0;
    }
    public int deletelearnrouter(String id){
        if(id != null) return learnContentMapper.deletelearnrouter(id);
        else return 0;
    }
    public int updatelearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null) return learnContentMapper.updatelearnrouter(learnRouter1);
        else return 0;
    }
    public int updatelearnrouter1(LearnRouter1 learnRouter1){
        if(learnRouter1 != null)  return learnContentMapper.updatelearnrouter1(learnRouter1);
        else return 0;
    }


}
