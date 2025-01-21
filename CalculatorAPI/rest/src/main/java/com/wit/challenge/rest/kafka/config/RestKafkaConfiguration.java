package com.wit.challenge.rest.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class RestKafkaConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${topics.calculator.request}")
    private String calculatorRequestTopic;

    @Value("${topics.calculator.answer}")
    private String calculatorAnswerTopic;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> properties = kafkaProperties
                .buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // topic: rest writes and calculator reads
    @Bean
    public NewTopic calculatorRequestTopicBuilder() {
        return TopicBuilder
                .name(calculatorRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    // topic: calculator writes and rest reads
    @Bean
    public NewTopic calculatorAnswerTopicBuilder() {
        return TopicBuilder
                .name(calculatorAnswerTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
