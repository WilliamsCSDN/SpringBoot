package com.dubbo.provider.service;

import com.dubbo.api.model.Comment;
import com.dubbo.api.service.CommentService;

import com.dubbo.provider.mapper.CommentMapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CommentServiceImpl implements CommentService{
    @Resource
    CommentMapper commentMapper;
    @Autowired
    private RedissonClient redissonClient;
    public List<Comment> findAll(String articleid){
        if(articleid!=null)
            return commentMapper.findAll(articleid);
        else return null;
    }
    public int insertcomment(String articleid, String name, String content, String createtime, String state){
        if(articleid!=null && name!=null && content!=null)
            return commentMapper.insertcomment(articleid,name,content,createtime,state);
        else return 0;
    }
    public int insertcomment1( String comment_id,String name,String replyname,String content,String prase_count,String createtime){
        if(comment_id!=null && name!=null && content!=null)
             return commentMapper.insertcomment1(comment_id,name,replyname,content,prase_count,createtime);
        else return 0;
    }
    public  boolean updatesh(String id,String state){
        if(id!=null) {
            RLock lock = redissonClient.getLock(id);
            try {
                boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
                if (!res) return false;
                System.out.println("加锁成功！");
                commentMapper.updatesh(id, state);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                lock.unlock();
                System.out.println("解锁成功！");
            }
            return true;
        }else return false;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public int deletecomment(String id){
        int a;
        if(id!=null) {
            a=commentMapper.deletecomment(id);
            commentMapper.deletecomment1(id);
            return a;
        }else return 0;
    }

}
