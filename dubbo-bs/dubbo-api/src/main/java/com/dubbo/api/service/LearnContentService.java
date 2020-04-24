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
<<<<<<< HEAD
    public void deletelearncontent(String id);
    public void insertlearncontent(LearnContent learnContent);
    public boolean updatelearncontent(LearnContent learnContent);
    public void insertlearnrouter(LearnRouter1 learnRouter1);
    public void deletelearnrouter(String id);
    public void updatelearnrouter(LearnRouter1 learnRouter1);
    public void updatelearnrouter1(LearnRouter1 learnRouter1);
=======
    public int deletelearncontent(String id);
    public int insertlearncontent(LearnContent learnContent);
    public int updatelearncontent(LearnContent learnContent);
    public int insertlearnrouter(LearnRouter1 learnRouter1);
    public int deletelearnrouter(String id);
    public int updatelearnrouter(LearnRouter1 learnRouter1);
    public int updatelearnrouter1(LearnRouter1 learnRouter1);
>>>>>>> b817bb3d3a22c0c4694457d79fcc82f7f0c6e5d4

}
