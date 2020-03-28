package com.xbang.rabbitmq.provider.sender;


import com.xbang.rabbitmq.provider.utils.CorrelationDataUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface Sender {

    RabbitTemplate getRabbitTemplate();

    default  void sendMsg(String queueName,Object content){
        if(!support(content)){
            log(getSenderName() + " 不支持该类型的消息.");
            return ;
        }

        getRabbitTemplate().convertAndSend(queueName,convertStringContent(content),CorrelationDataUtils.generate());

    }

    default void log(Object object){
        System.out.println(object.toString());
    }

    default  String getSenderName(){
        return this.getClass().getName();
    }


    default boolean support(Object content){
        return true;
    }

    default Object convertStringContent(Object content){
        return getSenderName() + ":" + content.toString();
    }

}
