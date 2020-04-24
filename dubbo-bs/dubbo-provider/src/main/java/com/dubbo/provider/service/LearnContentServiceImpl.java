package com.dubbo.provider.service;


import com.dubbo.api.model.LearnContent;
import com.dubbo.api.model.LearnRouter1;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.LearnContentService;
import com.dubbo.provider.mapper.LearnContentMapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LearnContentServiceImpl implements LearnContentService {
    @Resource
    LearnContentMapper learnContentMapper;
<<<<<<< HEAD
    @Autowired
    private RedissonClient redissonClient;
=======

>>>>>>> b817bb3d3a22c0c4694457d79fcc82f7f0c6e5d4
    public List<LearnContent> selectAll(String id, String start, String num){
        return learnContentMapper.selectAll(id,start,num);
    }
    public List<LearnContent> selectHot(String id){ return learnContentMapper.selectHot(id);}
<<<<<<< HEAD
    public List<LearnRouter1> getrouterbyid(String id) {return  learnContentMapper.getrouterbyid(id);}
    public List<LearnContent> getlearncontent(String id,String author){return learnContentMapper.getlearncontent(id,author);}
    public void deletelearncontent(String id){learnContentMapper.deletelearncontent(id);}
    public void insertlearncontent(LearnContent learnContent){learnContentMapper.insertlearncontent(learnContent);}
    public boolean updatelearncontent(LearnContent learnContent){
        String learnContenId=""+learnContent.getId();
        RLock lock = redissonClient.getLock(learnContenId);
        boolean res= false;
        try {
            res = lock.tryLock(100,10, TimeUnit.SECONDS);
            if(!res) return false;
            System.out.println("加锁成功！");
            learnContentMapper.updatelearncontent(learnContent);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }finally {
            lock.unlock();
            System.out.println("解锁成功！");
        }
        return true;
    }
    public void insertlearnrouter(LearnRouter1 learnRouter1){learnContentMapper.insertlearnrouter(learnRouter1);}
    public void deletelearnrouter(String id){learnContentMapper.deletelearnrouter(id);}
    public void updatelearnrouter(LearnRouter1 learnRouter1){learnContentMapper.updatelearnrouter(learnRouter1);}
    public void updatelearnrouter1(LearnRouter1 learnRouter1){learnContentMapper.updatelearnrouter1(learnRouter1);}
=======
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
>>>>>>> b817bb3d3a22c0c4694457d79fcc82f7f0c6e5d4


}
