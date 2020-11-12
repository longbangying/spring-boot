package com.xbang.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/11
 * update date: 2020/11/11
 */
@Configuration
public class CacheConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        RedisCacheConfiguration redisCacheConfiguration
                = RedisCacheConfiguration.defaultCacheConfig()

                //过期时间
                .entryTtl(Duration.ofMinutes(60));
        return redisCacheConfiguration;
    }
}
