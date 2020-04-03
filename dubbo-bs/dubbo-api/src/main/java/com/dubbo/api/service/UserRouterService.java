package com.dubbo.api.service;


import com.dubbo.api.model.UserRouter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRouterService {

    public void insertrouter(String id, String learnrouter);
    public List<UserRouter> getuserr(String id);
    public void deleterouter(String id,String learnrouter);
    public void updateLearnContent1(int id);
    public void updateLearnContent2(int id);
}
