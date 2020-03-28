package com.xbang.rabbitmq.provider.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender2 implements Sender {
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
        return content instanceof String;
    }

}
