package com.dubbo.provider.service;


import com.dubbo.api.model.UserKC;
import com.dubbo.api.service.CommentService;
import com.dubbo.api.service.UserKCService;
import com.dubbo.provider.mapper.UserKCMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserKCServiceImpl implements UserKCService {
    @Resource
    UserKCMapper userKCMapper;

    public void insertkc(String id,String kc){
        if(id !=null &&kc != null) {
            userKCMapper.insertkc(id, kc);
        }
    }

    public List<UserKC> getuserk(String id){
        if(id != null) {
            return userKCMapper.getuserk(id);
        }else return null;
    }
    public void deletekc(String id,String kc){
        if(id != null && kc != null) {
            userKCMapper.deletekc(id, kc);
        }
    }
    public void updateSearch1(int id){
        if((Integer)id != null) {
            userKCMapper.updateSearch1(id);
        }
    }
    public void updateSearch2(int id){
        if((Integer)id != null) {
            userKCMapper.updateSearch2(id);
        }
    }
}
