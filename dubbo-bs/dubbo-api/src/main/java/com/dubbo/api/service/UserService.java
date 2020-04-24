package com.dubbo.api.service;


import com.dubbo.api.model.Permission;
import com.dubbo.api.model.User;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface UserService {


    public User findByUsername(String username);
    public List<User> findAll();
    public List<User> findByName(String username,String password);

    public int register(String username,String password,String identity) ;

    public List<Permission> getpermission(String iid);
    public int updateUser(User user);
    public int updateUser1(User user);
    public List<User> findById(String id);
    public int deleteById(String id);
//    public void updatePassword(String id,String password);
   public int updatePassword(String username,String password,String oldpassword);

    public int addUser(User user);
    public Object getUser(String username, String password, String token);
    public int remove(String token);

}
