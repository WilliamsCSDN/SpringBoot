package com.dubbo.api.service;


import com.dubbo.api.model.UserKC;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserKCService {

    public int insertkc(String id,String kc);

    public List<UserKC> getuserk(String id);
    public int deletekc(String id,String kc);
    public int updateSearch1(int id);
    public int updateSearch2(int id);
}
