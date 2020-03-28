package com.xbang.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.SaveMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Slf4j
@SpringBootApplication
//@EnableRedisHttpSession(redisNamespace="spring::session::test",saveMode = SaveMode.ALWAYS)
public class SessionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SessionApplication.class,args);
    }
}
