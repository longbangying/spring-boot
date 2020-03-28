package com.xbang.rabbitmq.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication(scanBasePackages={"com.xbang.rabbitmq.provider","com.xbang.mybatis"})
public class ProviderApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("args:{}",args);
        if(!rabbitTemplate.isConfirmListener()){
            //确认回调
            //correlationData 为发送前配置的相关信息(原文返回 ID最好唯一)
            //b  标识  true(exchange 已经收到消息)   false(exchange未收到消息)
            //s  失败消息
            rabbitTemplate.setConfirmCallback((correlationData,b,s)->{
                log.info("comfirmCallBack:{} b:{} s:{}",correlationData,b,s);
            });
        }
        //
        if(!rabbitTemplate.isReturnListener()){
            rabbitTemplate.setReturnCallback((message,var1,var2,var3,var4)->{
                log.info("message:{} var1:{} var2:{} var3:{} var4:{}", message, var1, var2, var3, var4);
            });
        }

    }
}
