package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(Controller.class);

    private final KafkaTemplate kafkaTemplate;

    public Controller(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/pass-to-kafka")
    public void passToKafka(@RequestBody String message) {
        logger.info("This log message has trace id and span id");
        kafkaTemplate.send("my-test-topic", message);
    }
}

