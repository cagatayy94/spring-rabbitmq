package com.cookbook.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConf {

    @Value("${my.rabbitmq.exchange}")
    String exchange;

    @Value("${my.rabbitmq.queue}")
    String queueName;

    @Value("${my.rabbitmq.routingKey}")
    String routingKey;

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(this.exchange);
    }

    @Bean
    Queue queue(){
        return new Queue(this.queueName, true);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(this.routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
