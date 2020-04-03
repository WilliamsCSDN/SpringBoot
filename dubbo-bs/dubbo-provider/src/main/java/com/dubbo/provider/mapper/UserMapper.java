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
    public void register(@Param("username") String username, @Param("password") String password, @Param("identity") String identity);
    public List<Permission> getpermission(@Param("iid") String iid);
    public void updateUser(@Param("user") User user);
    public void updateUser1(@Param("user") User user);
    public List<User> findById(@Param("id") String id);
    public void deleteById(@Param("id") String id);
    public void updatePassword(@Param("id") String id, @Param("password") String password);
    public void addUser(@Param("user") User user);


}
