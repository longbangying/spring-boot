package com.xbang.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.xbang")
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class,args);
    }
}
