package com.cookbook.rabbitmq.service;

import dto.MessageRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageManager implements MessageService{

    private final DirectExchange directExchange;
    private final AmqpTemplate amqpTemplate;

    @Value("${my.rabbitmq.routingKey}")
    String routingKey;

    @Value("${my.rabbitmq.queue}")
    String queueName;

    public MessageManager(DirectExchange directExchange, AmqpTemplate amqpTemplate) {
        this.directExchange = directExchange;
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendMessageToQueue(MessageRequest messageRequest) {
        this.amqpTemplate.convertAndSend(this.directExchange.getName(), this.routingKey, messageRequest);
    }

    @RabbitListener(queues = "${my.rabbitmq.queue}")
    @Override
    public void getMessageFromQueue(MessageRequest messageRequest) {
        //this direct fetches message from queue
        System.out.println("Fetching messages from queue");
        System.out.println(messageRequest);
    }
}
