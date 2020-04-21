package com.dubbo.customer.config;


import com.dubbo.customer.filter.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    TestInterceptor testInterceptor(){
        return new TestInterceptor();
    }
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePathLists=new ArrayList<>();
        excludePathLists.add("/getUser");
        excludePathLists.add("/getheader1");
        excludePathLists.add("/getlearncontent");
        excludePathLists.add("/gethot");
        excludePathLists.add("/getHotsearch");
        excludePathLists.add("/search");
        excludePathLists.add("/1");
        excludePathLists.add("/3");

//        registry.addInterceptor(testInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(excludePathLists);
        super.addInterceptors(registry);
    }
}
