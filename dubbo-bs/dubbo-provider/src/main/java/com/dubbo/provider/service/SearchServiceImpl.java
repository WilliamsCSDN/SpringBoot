package com.dubbo.provider.service;


import com.dubbo.api.model.Search;
import com.dubbo.api.service.SearchService;
import com.dubbo.provider.mapper.SearchMapper;
import com.dubbo.provider.util.RedisLockCommon;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    SearchMapper searchMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedissonClient redissonClient;
    @Resource
    public RedisLockCommon redisLock;
    public List<Search> findAll(String a, String start, String num){
        return searchMapper.findAll(a,start,num);
    }
    public List<Search> findById(String id,String author){return searchMapper.findById(id,author);}
    public Boolean updateimg(Search search){
        if(search != null) {
            String searchId = "" + search.getId();
            RLock lock = redissonClient.getLock(searchId);
            try {
                boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
                if (!res) return false;
                System.out.println("加锁成功！");
                searchMapper.updateimg(search);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                lock.unlock();
                redisTemplate.opsForZSet().removeRange("page", 0, -1);
                search2(null, null);
                System.out.println("解锁成功！");
            }
            return true;
        }else return false;
    }
    public int insertlesson(Search search){
        if(search != null) {
            int a=searchMapper.insertlesson(search);
            redisTemplate.opsForZSet().removeRange("page", 0, -1);
            search2(null, null);
            return a;
        }else return 0;
    }
    public int deletelesson(String id){
        if(id != null) {
            int a = searchMapper.deletelesson(id);
            redisTemplate.opsForZSet().removeRange("page", 0, -1);
            search2(null, null);
            return a;
        }else return 0;
    }
    public List<Search> getHotsearch(){
        return searchMapper.getHotsearch();
    }
    public Object search1(String a,String b){
        if(a==null||b==null)
            return redisTemplate.opsForZSet().range("page",0,-1);
        else return redisTemplate.opsForZSet().range("page",Long.parseLong(a),Long.parseLong(b)+Long.parseLong(a)-1);
    }
    public Object search2(String a,String b){
        String key="page";
        if((redisTemplate.opsForZSet().range("page", 0, -1)).size()==0) {
            System.out.println("数据库获取数据");
            List<Search> search = findAll(null, null, null);
            for (Search search3 : search)
                redisTemplate.opsForZSet().add(key, search3, 1);
        }else {
            System.out.println("redis获取数据");
        }
        if (a == null || b == null)
            return redisTemplate.opsForZSet().range("page", 0, -1);
        else {
            System.out.println("redis分页");
            return redisTemplate.opsForZSet().range("page", Long.parseLong(a), Long.parseLong(b) + Long.parseLong(a) - 1);
        }
    }
    public List<Search> search2(int url){
        if((Integer)url != null) return searchMapper.search2(url);
        else return null;
    }
    public int selectBestId(){return searchMapper.selectBestId();}
    public int selectBestId1(){return searchMapper.selectBestId1();}
    public Object findAll1(String start,String num){
        if(start !=null && num != null) return searchMapper.findAll1(start,num);
        else return null;
    }

}
