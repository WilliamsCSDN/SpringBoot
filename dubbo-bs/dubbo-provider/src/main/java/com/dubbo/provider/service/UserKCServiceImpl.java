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

    public void insertkc(String id,String kc){userKCMapper.insertkc(id,kc);}

    public List<UserKC> getuserk(String id){return userKCMapper.getuserk(id);}
    public void deletekc(String id,String kc){ userKCMapper.deletekc(id,kc);}
    public void updateSearch1(int id){userKCMapper.updateSearch1(id);}
    public void updateSearch2(int id){userKCMapper.updateSearch2(id);}
}
