package com.xbang.rabbitmq.provider;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderApplicationTest {

    @Autowired
    AmqpTemplate rabbitmqTemplate;


    @Test
    public void sendMsg(){
        rabbitmqTemplate.convertAndSend("hello","hello rabbitmq");
    }


}
