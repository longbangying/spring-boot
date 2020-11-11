package com.xbang.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RedisApplication.class,args);
        StringRedisTemplate stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
        Set<String> keys = stringRedisTemplate.keys("*");
        keys.forEach(System.out::println);

    }
}
