package com.cookbook.rabbitmq.service;

import dto.MessageRequest;

public interface MessageService {
    void sendMessageToQueue(MessageRequest messageRequest);
}
