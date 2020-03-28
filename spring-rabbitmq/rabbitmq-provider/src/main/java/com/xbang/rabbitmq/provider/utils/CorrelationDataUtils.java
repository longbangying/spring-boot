package com.xbang.rabbitmq.provider.utils;

import org.springframework.amqp.rabbit.connection.CorrelationData;

public class CorrelationDataUtils {

    public static CorrelationData generate(){
       return new CorrelationData(System.currentTimeMillis()+"");

    }

    public static CorrelationData generate(String id){
        return new CorrelationData(id);

    }
}
