package com.example;

import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
class SandboxController {

    final String destination = "fifo-sqs-sample";

    @GetMapping("producer")
    HttpStatus producer() {
        System.out.println("queue producer");
        queueMessagingTemplate.convertAndSend(destination, MessageBuilder.withPayload("queue send sample").build());
        return HttpStatus.OK;
    }

    QueueMessagingTemplate queueMessagingTemplate;

    SandboxController(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }
}