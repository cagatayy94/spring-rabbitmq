package com.cookbook.rabbitmq.controller;

import com.cookbook.rabbitmq.service.MessageService;
import dto.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DefaultController {
    private final MessageService messageService;

    @Autowired
    public DefaultController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("addMessageToQueue")
    public ResponseEntity<String> addMessageToQueue(@RequestBody MessageRequest messageRequest){
        this.messageService.sendMessageToQueue(messageRequest);
        return ResponseEntity.ok("Success");
    }
}
