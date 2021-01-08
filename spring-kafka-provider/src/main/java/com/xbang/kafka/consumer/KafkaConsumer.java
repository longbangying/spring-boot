package com.xbang.kafka.consumer;

import com.xbang.kafka.service.DelayService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    DelayService delayService;

    @KafkaListener(topics = "xbang",groupId = "1")
    public void msgHandler(ConsumerRecord<String,String> record){

        System.out.println(DATE_TIME_FORMATTER.format(LocalDateTime.now()) + " 收到:" + record.value());
        delayService.onMessage("xbang-delay",record.value());

    }

    //@KafkaListener(topics = "xbang",groupId = "1")
    public void msgHandler1(ConsumerRecord<String,String> record){

        System.out.println("收到1:" + record.value());

    }

    //@KafkaListener(topics = "xbang",groupId = "2")
    public void msgHandler2(ConsumerRecord<String,String> record){

        System.out.println("收到2:" + record.value());

    }


    @KafkaListener(topics = "xbang-delay",groupId = "1")
    public void delayHandler(ConsumerRecord<String,String> record){
        System.out.println(DATE_TIME_FORMATTER.format(LocalDateTime.now()) + " 收到2延迟队列:" + record.value());

    }
}
