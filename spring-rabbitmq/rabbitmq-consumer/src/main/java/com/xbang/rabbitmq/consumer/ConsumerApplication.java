package com.xbang.rabbitmq.consumer;

import com.xbang.commons.entity.UserInfo;
import com.xbang.rabbitmq.consumer.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
//@RabbitListener(queues = RabbitMQConfig.SPRING_BOOT_QUEUE)
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    /**
     * 多消费者时,没条消息只能被消费一次
     * @param content
     */
    /*@RabbitHandler
    public void process(Object object){
        if(object instanceof  String){
            log.info("Listener接收到消息:{}",object);
        }
        if(object instanceof UserInfo){
            log.info("Listener接收到消息:{}",object.toString());
        }

    }*/

    /**
     * 多消费者时,没条消息只能被消费一次
     * @param content
     */
    //@RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.SPRING_BOOT_QUEUE)
    public void process(UserInfo object){
        log.info("Listener接收到消息:{}",object);


    }
}
