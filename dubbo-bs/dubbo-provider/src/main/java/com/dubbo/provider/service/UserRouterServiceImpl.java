package com.dubbo.provider.service;


import com.dubbo.api.model.UserRouter;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.UserRouterService;
import com.dubbo.provider.mapper.UserRouterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRouterServiceImpl implements UserRouterService {
    @Resource
    UserRouterMapper userRouterMapper;
    public int insertrouter(String id, String learnrouter){
        if(id != null && learnrouter != null) {
            return userRouterMapper.insertrouter(id, learnrouter);
        }else return 0;
    }
    public List<UserRouter> getuserr(String id){
        if(id != null) return userRouterMapper.getuserr(id);
        else return null;
    }
    public int deleterouter(String id,String learnrouter){
        if(id !=null && learnrouter != null) {
            return userRouterMapper.deleterouter(id, learnrouter);
        }else return 0;
    }
    public int updateLearnContent1(int id){
        if((Integer) id != null) {
            return userRouterMapper.updateLearnContent1(id);
        }else return 0;
    }
    public int updateLearnContent2(int id){
        if((Integer)id != null)
           return userRouterMapper.updateLearnContent2(id);
        else return 0;
    }
}
