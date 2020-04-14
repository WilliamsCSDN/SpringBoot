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

    public int insertkc(String id,String kc){
        if(id !=null &&kc != null) {
            return userKCMapper.insertkc(id, kc);
        }else return 0;
    }

    public List<UserKC> getuserk(String id){
        if(id != null) {
            return userKCMapper.getuserk(id);
        }else return null;
    }
    public int deletekc(String id,String kc){
        if(id != null && kc != null) {
           return userKCMapper.deletekc(id, kc);
        }else return 0;
    }
    public int updateSearch1(int id){
        if((Integer)id != null) {
           return userKCMapper.updateSearch1(id);
        }else return 0;
    }
    public int updateSearch2(int id){
        if((Integer)id != null) {
           return userKCMapper.updateSearch2(id);
        }else return 0;
    }
}
