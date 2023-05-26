package com.alin.messageByme.controller;

import com.alin.messageByme.kafkaTest.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：raozl
 * @Date：2023/5/6 11:03
 */
@RestController
public class KafkaTestController {
    @Autowired
    private UserLogProducer userLogProducer;

    /**
     * test insert
     */
    @GetMapping("/kafka/insert")
    public String insert(String userId) {
        userLogProducer.sendLog(userId);

        return null;
    }
}
