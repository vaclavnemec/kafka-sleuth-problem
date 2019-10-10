package com.example.demo;

import brave.sampler.Sampler;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.ProducerListener;

@SpringBootApplication
public class DemoApplication {

	private final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ProducerListener myProducerListener() {
		return new ProducerListener<>() {
			@Override
			public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
				logger.info("This log message is missing trace id and span id");
			}
		};
	}

	@Bean
	Sampler mySampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
