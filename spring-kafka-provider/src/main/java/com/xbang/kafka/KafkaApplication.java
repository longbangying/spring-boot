package com.xbang.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/23
 * update date: 2020/12/23
 */
@SpringBootApplication
@EnableKafka
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
