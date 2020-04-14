package com.dubbo.api.service;


import com.dubbo.api.model.UserRouter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRouterService {

    public int insertrouter(String id, String learnrouter);
    public List<UserRouter> getuserr(String id);
    public int deleterouter(String id,String learnrouter);
    public int updateLearnContent1(int id);
    public int updateLearnContent2(int id);
}
