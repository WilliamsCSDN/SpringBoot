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
    @Autowired
    private RedissonClient redissonClient;
    public List<LearnContent> selectAll(String id, String start, String num){
        return learnContentMapper.selectAll(id,start,num);
    }
    public List<LearnContent> selectHot(String id){ return learnContentMapper.selectHot(id);}
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


}
