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
    public void deletelearncontent(String id);
    public void insertlearncontent(LearnContent learnContent);
    public boolean updatelearncontent(LearnContent learnContent);
    public void insertlearnrouter(LearnRouter1 learnRouter1);
    public void deletelearnrouter(String id);
    public void updatelearnrouter(LearnRouter1 learnRouter1);
    public void updatelearnrouter1(LearnRouter1 learnRouter1);

}
