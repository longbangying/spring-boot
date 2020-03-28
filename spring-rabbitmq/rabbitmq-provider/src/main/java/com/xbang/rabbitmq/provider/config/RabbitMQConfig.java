package com.xbang.rabbitmq.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static  final String SPRING_BOOT_QUEUE = "spring-boot-queue";

    public static  final String SPRING_BOOT_EXCHANGE = "spring-boot-exchange";

    public static  final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key";

    /**
     * 定义消息队列
     * @return
     */
    @Bean
    public Queue helloQueue(){
        return new Queue(SPRING_BOOT_QUEUE);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    public TopicExchange exchange (){
        return new TopicExchange(SPRING_BOOT_EXCHANGE);
    }

    /**
     * 将交换机和消息队列绑定
     * @param queue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(SPRING_BOOT_BIND_KEY);
    }

    //@Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
