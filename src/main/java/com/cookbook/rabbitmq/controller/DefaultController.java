package com.cookbook.rabbitmq.controller;

import dto.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DefaultController {
    @PostMapping("addMessageToQueue")
    public ResponseEntity<String> addMessageToQueue(@RequestBody MessageRequest messageRequest){
        System.out.println(messageRequest);
        return ResponseEntity.ok("Success");
    }
}
