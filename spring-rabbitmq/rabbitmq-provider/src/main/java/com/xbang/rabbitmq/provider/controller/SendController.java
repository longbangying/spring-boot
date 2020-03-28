package com.xbang.rabbitmq.provider.controller;

import com.xbang.commons.entity.UserInfo;
import com.xbang.commons.vo.result.BaseResult;
import com.xbang.commons.vo.result.Result;
import com.xbang.commons.vo.result.ResultEnum;
import com.xbang.rabbitmq.provider.config.RabbitMQConfig;
import com.xbang.rabbitmq.provider.sender.Sender;
import com.xbang.rabbitmq.provider.sender.UserInfoSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
public class SendController {

    @Autowired
    List<Sender> senderList;

    @Autowired
    UserInfoSender userInfoSender;

    @GetMapping("send")
    public String send(String content){
        try {
            senderList.stream().forEach(item->item.sendMsg(RabbitMQConfig.SPRING_BOOT_QUEUE,content));
        } catch (AmqpException e) {
            e.printStackTrace();
        }
        log.info("发送完成.");
        return "success";
    }


    @PostMapping("sendObject")
    public Result sendObject(@RequestBody UserInfo userInfo){
        try {
            senderList.stream().forEach(item->item.sendMsg(RabbitMQConfig.SPRING_BOOT_QUEUE,userInfo));
        } catch (AmqpException e) {
            log.error(e.getMessage(),e);
        }
        log.info("发送完成.");
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"");
    }

    @PostMapping("sendTest")
    public Result sendTest(@RequestBody UserInfo userInfo){
        try {
            userInfoSender.send(userInfo);
        } catch (AmqpException e) {
            log.error(e.getMessage(),e);
        }
        //log.info("发送完成.");
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,"");
    }

    @GetMapping("batchOP")
    public Result batchOP(int time){
        CompletableFuture.runAsync(()->{userInfoSender.multSend(time);});
        return BaseResult.getResult(ResultEnum.RESULT_SUCCESS,null);
    }
}
