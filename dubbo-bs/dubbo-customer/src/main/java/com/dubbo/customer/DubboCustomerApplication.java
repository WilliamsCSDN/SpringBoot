package com.dubbo.customer;

import com.dubbo.api.model.User;
import com.dubbo.api.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@SpringBootApplication
@ImportResource(value = {"classpath:dubbo-customer.xml"})

public class DubboCustomerApplication {

    public static void main(String[] args) {
        ApplicationContext tc = SpringApplication.run(DubboCustomerApplication.class, args);
//        UserService userService = (UserService) tc.getBean("userService");
//        List<User> user = userService.findAll();
//        for(User user1:user)
//            System.out.println(user1.name);
    }

}
