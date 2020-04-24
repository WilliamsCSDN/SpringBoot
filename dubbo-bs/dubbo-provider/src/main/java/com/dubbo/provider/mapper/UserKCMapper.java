package com.dubbo.provider.mapper;


import com.dubbo.api.model.UserKC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserKCMapper {
    public int insertkc(@Param("id") String id, @Param("kc") String kc);

    public List<UserKC> getuserk(@Param("id") String id);
    public int deletekc(@Param("id") String id, @Param("kc") String kc);
    public int updateSearch1(@Param("id") int id);
    public int updateSearch2(@Param("id") int id);
}
