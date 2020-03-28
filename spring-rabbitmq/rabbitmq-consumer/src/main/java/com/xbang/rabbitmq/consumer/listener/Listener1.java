package com.xbang.rabbitmq.consumer.listener;

import com.xbang.commons.entity.UserInfo;
import com.xbang.rabbitmq.consumer.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@RabbitListener(queues = RabbitMQConfig.SPRING_BOOT_QUEUE)
public class Listener1 {

    //@RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.SPRING_BOOT_QUEUE)
    public void process(UserInfo content){
        log.info("Listener1接收到消息:{}",content);
    }
}
