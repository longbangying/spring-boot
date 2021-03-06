package com.xbang.rabbitmq.provider.receive;

import com.xbang.commons.entity.UserInfo;
import com.xbang.mybatis.mapper.UserInfoMapper;
import com.xbang.rabbitmq.provider.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RabbitListener(queues = {RabbitMQConfig.SPRING_BOOT_QUEUE})
public class receive {

    @Autowired
    UserInfoMapper userInfoMapper;
    @RabbitHandler
    public void receive(UserInfo userInfo){

        log.info("receive:{}",userInfo);
        com.xbang.mybatis.entity.UserInfo userInfo1 = new com.xbang.mybatis.entity.UserInfo();
        BeanUtils.copyProperties(userInfo,userInfo1);
        userInfoMapper.insert(userInfo1);

    }
}
