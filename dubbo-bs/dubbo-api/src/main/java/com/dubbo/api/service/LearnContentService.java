package com.dubbo.api.service;


import com.dubbo.api.model.LearnContent;
import com.dubbo.api.model.LearnRouter1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LearnContentService {

    public List<LearnContent> selectAll(String id, String start, String num);
    public List<LearnContent> selectHot(String id);
    public List<LearnRouter1> getrouterbyid(String id);
    public List<LearnContent> getlearncontent(String id,String author);
    public int deletelearncontent(String id);
    public int insertlearncontent(LearnContent learnContent);
    public int updatelearncontent(LearnContent learnContent);
    public int insertlearnrouter(LearnRouter1 learnRouter1);
    public int deletelearnrouter(String id);
    public int updatelearnrouter(LearnRouter1 learnRouter1);
    public int updatelearnrouter1(LearnRouter1 learnRouter1);

}
