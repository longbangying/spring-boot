package com.xbang.cache;

import com.xbang.cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@EnableCaching
public class SpringCacheDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringCacheDemoApplication.class, args);
        UserService userService = configurableApplicationContext.getBean(UserService.class);
    }
}
