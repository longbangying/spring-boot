package com.xbang.rabbitmq.provider.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xbang.commons.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserInfoSender1 implements Sender {
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
        /*ObjectMapper objectMapper = new ObjectMapper();
        try {
            content = objectMapper.writeValueAsString(userInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        return content;
    }


}
