package com.dubbo.provider.mapper;


import com.dubbo.api.model.UserRouter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRouterMapper {
    public void insertrouter(@Param("id") String id, @Param("learnrouter") String learnrouter);
    public List<UserRouter> getuserr(@Param("id") String id);
    public void deleterouter(@Param("id") String id, @Param("learnrouter") String learnrouter);
    public void updateLearnContent1(@Param("id") int id);
    public void updateLearnContent2(@Param("id") int id);
}
