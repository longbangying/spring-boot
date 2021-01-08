package com.xbang.kafka.service;

import com.xbang.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2021/1/7
 * update date: 2021/1/7
 */
@Component
public class DelayService implements Runnable{

    @Autowired
    KafkaProducer kafkaProducer;

    private DelayQueue<ObjectItem> delayQueue = new DelayQueue();


    public void onMessage(String topic,String content){

        ObjectItem objectItem = new ObjectItem(content,5,TimeUnit.SECONDS,topic);
        delayQueue.add(objectItem);
    }


    @Override
    public void run() {
        while (true){
            try {
                ObjectItem objectItem = delayQueue.take();
                kafkaProducer.sendMsg(objectItem.topic,objectItem.content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ObjectItem implements Delayed{

        private String content;

        private String topic;

        private long time;

        public ObjectItem(String content, long time,TimeUnit timeUnit,String topic) {
            this.content = content;
            this.time = System.currentTimeMillis() + timeUnit.toMillis(time);
            this.topic = topic;
        }

        @Override
        public long getDelay(TimeUnit unit) {

            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            ObjectItem objectItem = (ObjectItem)o;
            long diff = this.time - objectItem.time;
            if(diff <= 0){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
