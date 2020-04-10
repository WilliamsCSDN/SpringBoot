package com.dubbo.provider.service;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Configuration
public class RedisLockCommon {
     @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
         RedissonClient redisson = Redisson.create(Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream()));
         return redisson;
     }


}
