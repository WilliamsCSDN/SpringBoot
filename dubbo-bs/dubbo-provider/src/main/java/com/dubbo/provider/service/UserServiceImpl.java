package com.dubbo.provider.service;

import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import com.dubbo.provider.mapper.UserMapper;
import com.dubbo.provider.util.MD5Util;
import com.dubbo.provider.util.RedisUtil;
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
        if(username != null) {
            return userMapper.findByUsername(username);
        }else return null;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByName(String username, String password) {
        if(username != null && password != null) {
            String md5password = MD5Util.formPassToDBPass(password, "456789");
            return userMapper.findByName(username, password);
        }else return null;
    }

    @Override
    public int register(String username, String password, String identity) {
        if(username!=null&&password!=null&&identity!=null) {
            String a = MD5Util.formPassToDBPass(password, "456789");
            return userMapper.register(username,password,identity);
        } else return 0;
    }

    @Override
    public List<Permission> getpermission(String iid) {
        if(iid != null) {
            return userMapper.getpermission(iid);
        }
        else return null;
    }

    @Override
    public int updateUser(User user) {
        if(user != null && user.getPassword()!=null && user.getUsername() != null) {
            String md5password = MD5Util.formPassToDBPass(user.getPassword(), "456789");
            user.setPassword(md5password);
            return userMapper.updateUser(user);
        }else return 0;
    }

    @Override
    public int updateUser1(User user) {
        if(user != null && user.getUsername() != null) {
            return userMapper.updateUser1(user);
        }else return 0;
    }

    @Override
    public List<User> findById(String id) {
        if(id != null) {
            return userMapper.findById(id);
        }
        else return null;
    }

    @Override
    public int deleteById(String id) {
        if(id != null) {
            return userMapper.deleteById(id);
        }else return 0;
    }

    @Override
    public int updatePassword(String username,String password,String oldpassword) {
        if(username != null && password != null && oldpassword != null) {
            int aa = 0;
            for (User a : findByName(username, oldpassword)) {
                if (String.valueOf(a.getId()) != "") {
                    String md5password = MD5Util.formPassToDBPass(password, "456789");
                   aa = userMapper.updatePassword(String.valueOf(a.getId()), md5password);
                }
            }
            return aa;
        }else return 0;

    }

    @Override
    public int addUser(User user) {
        if(user != null && user.getUsername() != null &&user.getPassword() != null) {
            String md5password = MD5Util.formPassToDBPass(user.getPassword(), "456789");
            user.setPassword(md5password);
            return userMapper.addUser(user);
        }else return 0;
    }

    public Object getUser(String username, String password, String token){
        if(token==null||"".equals(token)){
            String md5password = MD5Util.formPassToDBPass(password, "456789");
            if(username==null||password==null) return false;
            else {
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
                    return false;
                }
            }
        }else{
            System.out.println("从redis中获取list");
            return redisUtil.get(token);
        }
    }
    public int remove(String token){
        if(token != null) {
            redisUtil.del(token);
            return 1;
        }else  return 0;
        
    }
}
