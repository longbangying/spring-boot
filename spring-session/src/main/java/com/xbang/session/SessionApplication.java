package com.xbang.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.SaveMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.Collections;
import java.util.Set;

@Slf4j
@SpringBootApplication
//@EnableRedisHttpSession(redisNamespace="spring::session::test",saveMode = SaveMode.ALWAYS)
public class SessionApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SessionApplication.class,args);
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        Set<String> sessionKeys = redisTemplate.keys("spring:session*");
        if(null == sessionKeys || sessionKeys.isEmpty()){
            log.info("nothing to do...");
            return ;
        }
        sessionKeys.stream().map(item-> redisTemplate.delete(item));

    }
}
