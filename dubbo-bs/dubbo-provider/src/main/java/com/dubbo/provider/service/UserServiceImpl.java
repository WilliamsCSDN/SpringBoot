package com.dubbo.provider.service;

import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.provider.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    public RedisUtil redisUtil;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByName(String username, String password) {
        String md5password = MD5Util.formPassToDBPass(password, "456789");
        return userMapper.findByName(username, password);
    }

    @Override
    public String register(String username, String password, String identity) {
        if(username!=null&&password!=null&&identity!=null) {
            String a = MD5Util.formPassToDBPass(password, "456789");
            userMapper.register(username,password,identity);
            return "添加成功！";
        }
        else return "添加失败";
    }

    @Override
    public List<Permission> getpermission(String iid) {
        return userMapper.getpermission(iid);
    }

    @Override
    public void updateUser(User user) {
        if(user.getPassword()!=null){
            String md5password = MD5Util.formPassToDBPass(user.getPassword(), "456789");
            user.setPassword(md5password);
        }
        userMapper.updateUser(user);
    }

    @Override
    public void updateUser1(User user) {
        userMapper.updateUser1(user);
    }

    @Override
    public List<User> findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public void updatePassword(String username,String password,String oldpassword) {
        for(User a:findByName(username,oldpassword)) {
            if (String.valueOf(a.getId())!="") {
                String md5password = MD5Util.formPassToDBPass(password, "456789");
                userMapper.updatePassword(String.valueOf(a.getId()), md5password);

            }
        }

    }

    @Override
    public void addUser(User user) {
        String md5password = MD5Util.formPassToDBPass(user.getPassword(), "456789");
        user.setPassword(md5password);
        userMapper.addUser(user);
    }

    public Object getUser(String username, String password, String token){
        System.out.println(username+password);
        if(token==null||"".equals(token)){
            String md5password = MD5Util.formPassToDBPass(password, "456789");
            if(username==null||password==null) return false;
            else {
                System.out.println(findByName(username,password).toString());
                if(findByName(username,md5password).toString()!="[]") {
                    token = UUID.randomUUID().toString().replace("-", "");
                    System.out.println("添加token到reids");
                    redisUtil.set(token, findByName(username, md5password));
//                    Cookie cookie = new Cookie("token", token);
//                    cookie.setMaxAge(24*3600);
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
                    return token;
                }else{
                    System.out.println(md5password+"123");
                    return false;
                }
            }
        }else{
            System.out.println("从redis中获取list");
            return redisUtil.get(token);
        }
    }
    public void remove(String token){
        redisUtil.del(token);
    }
}
