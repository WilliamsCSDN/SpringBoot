package com.dubbo.provider.service;


import com.dubbo.api.model.Search;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.SearchService;
import com.dubbo.provider.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    SearchMapper searchMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    public List<Search> findAll(String a, String start, String num){
        return searchMapper.findAll(a,start,num);
    }
    public List<Search> findById(String id,String author){return searchMapper.findById(id,author);}
    public void updateimg(Search search){
        searchMapper.updateimg(search);
        redisTemplate.opsForZSet().removeRange("page",0,-1);
        search2(null,null);
    }
    public void insertlesson(Search search){
        searchMapper.insertlesson(search);
        redisTemplate.opsForZSet().removeRange("page",0,-1);
        search2(null,null);
    }
    public void deletelesson(String id){
        searchMapper.deletelesson(id);
        redisTemplate.opsForZSet().removeRange("page",0,-1);
        search2(null,null);
    }
    public List<Search> getHotsearch(){ return  searchMapper.getHotsearch();}
    public Object search1(String a,String b){
        if(a==null||b==null)
            return redisTemplate.opsForZSet().range("page",0,-1);
        else return redisTemplate.opsForZSet().range("page",Long.parseLong(a),Long.parseLong(b)+Long.parseLong(a)-1);
    }
    public Object search2(String a,String b){
        String key="page";
        double total=findAll(null,null,null).size();
        List<Search> search=findAll(null,null,null);
        for(Search search3:search)
            redisTemplate.opsForZSet().add(key, search3, 1);
        if(a==null||b==null)
            return redisTemplate.opsForZSet().range("page",0,-1);
        else {
            System.out.println("redis分页");
            return redisTemplate.opsForZSet().range("page", Long.parseLong(a), Long.parseLong(b) + Long.parseLong(a) - 1);
        }
    }
    public List<Search> search2(int url){return searchMapper.search2(url);}
    public int selectBestId(){return searchMapper.selectBestId();}
    public int selectBestId1(){return searchMapper.selectBestId1();}
    public Object findAll1(String start,String num){return searchMapper.findAll1(start,num);}

}
