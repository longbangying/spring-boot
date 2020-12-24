package com.xbang.kafka.controller;

import com.xbang.commons.result.Result;
import com.xbang.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/24
 * update date: 2020/12/24
 */
@RestController
@RequestMapping("/kafka")
public class TestController {
    @Autowired
    KafkaProducer kafkaProducer;
    @GetMapping("/send")
    public Result sendMsg(String content){
        kafkaProducer.senderMsg(content);
        return Result.success();
    }
}
