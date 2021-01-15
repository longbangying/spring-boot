package com.xbang.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/12/24
 * update date: 2020/12/24
 */
@Component
public class KafkaProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void senderMsg(String content){
        sendMsg("xbang",content);
    }

    public void sendMsg(String topic,String content){
        ListenableFuture<SendResult> listenableFuture =  kafkaTemplate.send(topic,content);
        listenableFuture.addCallback(new ListenableFutureCallback(){
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("失败" );
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(Object o) {
                //System.out.println("成功");

            }
        });
    }
}
