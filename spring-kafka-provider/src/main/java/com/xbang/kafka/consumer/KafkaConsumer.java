package com.xbang.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/24
 * update date: 2020/12/24
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "xbang",groupId = "1")
    public void msgHandler(ConsumerRecord<String,String> record){

        System.out.println("收到:" + record.value());

    }
}
