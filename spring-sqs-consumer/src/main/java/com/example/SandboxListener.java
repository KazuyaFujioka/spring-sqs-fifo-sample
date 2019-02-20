package com.example;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
class SandboxListener {

    final String destination = "fifo-sqs-sample";

    @SqsListener(value = destination, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    void consumer(String message) {
        System.out.println("sqs consumer message=" + message);
    }
}