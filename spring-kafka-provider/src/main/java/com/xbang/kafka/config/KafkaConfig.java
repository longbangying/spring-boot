package com.xbang.kafka.config;

import com.xbang.kafka.service.DelayService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/7
 * update date: 2021/1/7
 */
@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic newTopic(){
        return new NewTopic("xbang-delay",1,(short) -1);
    }
    @Autowired
    DelayService delayService;
    @PostConstruct
    public void init(){
        new Thread(delayService).start();
    }
}
