package com.xbang.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @date 2020/5/14
 */
@Configuration
public class SpringConfig {
    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
