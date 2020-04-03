package com.dubbo.api.service;


import com.dubbo.api.model.UserKC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserKCService {

    public void insertkc(String id,String kc);

    public List<UserKC> getuserk(String id);
    public void deletekc(String id,String kc);
    public void updateSearch1(int id);
    public void updateSearch2(int id);
}
