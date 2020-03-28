package com.xbang.rabbitmq.provider.sender;

import com.xbang.commons.entity.UserInfo;
import com.xbang.rabbitmq.provider.config.RabbitMQConfig;
import com.xbang.rabbitmq.provider.utils.CorrelationDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class UserInfoSender implements Sender,Runnable {
    @Autowired
    RabbitTemplate rabbitmqTemplate;

    @Override
    public RabbitTemplate getRabbitTemplate() {
        return rabbitmqTemplate;
    }


    @Override
    public void log(Object object) {
        log.info(object.toString());
    }

    @Override
    public boolean support(Object content) {
        return content instanceof UserInfo;
    }

    @Override
    public Object convertStringContent(Object content) {
        UserInfo userInfo = (UserInfo) content;
        userInfo.setProvider(getSenderName());
        return content;
    }



    public void send(UserInfo userInfo){
        this.rabbitmqTemplate.convertAndSend(RabbitMQConfig.SPRING_BOOT_QUEUE,userInfo, CorrelationDataUtils.generate(userInfo.getUserId()));
    }

    @Override
    public void run() {

    }

    public void multSend(int time){

        for(int i=0;i< time;i++){

            //send(UserInfo.generate());
            com.xbang.mybatis.entity.UserInfo userInfo = com.xbang.mybatis.entity.UserInfo.create(UUID.randomUUID().toString());
            this.rabbitmqTemplate.convertAndSend(RabbitMQConfig.SPRING_BOOT_QUEUE,userInfo, CorrelationDataUtils.generate(userInfo.getUserName()) );

        }
    }
}
