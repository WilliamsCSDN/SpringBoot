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
    public void insertrouter(String id, String learnrouter){
        if(id != null && learnrouter != null) {
            userRouterMapper.insertrouter(id, learnrouter);
        }
    }
    public List<UserRouter> getuserr(String id){
        if(id != null) return userRouterMapper.getuserr(id);
        else return null;
    }
    public void deleterouter(String id,String learnrouter){
        if(id !=null && learnrouter != null)
           userRouterMapper.deleterouter(id,learnrouter);
    }
    public void updateLearnContent1(int id){
        if((Integer) id != null)
           userRouterMapper.updateLearnContent1(id);
    }
    public void updateLearnContent2(int id){
        if((Integer)id != null)
           userRouterMapper.updateLearnContent2(id);
    }
}
