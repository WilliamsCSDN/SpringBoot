package com.dubbo.customer.config;


import com.dubbo.customer.filter.TestInterceptor;
import com.dubbo.customer.filter.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    @Bean
    UserInterceptor userInterceptor(){return new UserInterceptor();}
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
        excludePathLists.add("/code");
        excludePathLists.add("/code1");
        excludePathLists.add("/searchById");
        excludePathLists.add("/searchcontent");
        excludePathLists.add("/comment");
        excludePathLists.add("/wenda1");
        excludePathLists.add("/favicon.ico");
        excludePathLists.add("/remove");


        registry.addInterceptor(userInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(testInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(excludePathLists);

        super.addInterceptors(registry);
    }

    /** 解决跨域问题 **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 允许跨域访问的路径
                .allowedOrigins("*")// 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
                .maxAge(168000)// 预检间隔时间
                .allowedHeaders("*")// 允许头部设置
                .allowCredentials(true);// 是否发送cookie
    }

}
