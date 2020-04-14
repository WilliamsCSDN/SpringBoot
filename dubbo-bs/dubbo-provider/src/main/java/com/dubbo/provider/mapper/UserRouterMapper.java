package com.dubbo.provider.mapper;


import com.dubbo.api.model.UserRouter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRouterMapper {
    public int insertrouter(@Param("id") String id, @Param("learnrouter") String learnrouter);
    public List<UserRouter> getuserr(@Param("id") String id);
    public int deleterouter(@Param("id") String id, @Param("learnrouter") String learnrouter);
    public int updateLearnContent1(@Param("id") int id);
    public int updateLearnContent2(@Param("id") int id);
}
