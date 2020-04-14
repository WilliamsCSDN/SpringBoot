package com.dubbo.provider.mapper;


import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public User findByUsername(String username);
    public List<User> findAll();
    public List<User> findByName(@Param("username") String username, @Param("password") String password);
    public int register(@Param("username") String username, @Param("password") String password, @Param("identity") String identity);
    public List<Permission> getpermission(@Param("iid") String iid);
    public int updateUser(@Param("user") User user);
    public int updateUser1(@Param("user") User user);
    public List<User> findById(@Param("id") String id);
    public int deleteById(@Param("id") String id);
    public int updatePassword(@Param("id") String id, @Param("password") String password);
    public int addUser(@Param("user") User user);


}
