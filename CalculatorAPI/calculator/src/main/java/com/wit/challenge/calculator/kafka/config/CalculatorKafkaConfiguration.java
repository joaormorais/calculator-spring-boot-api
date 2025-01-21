package com.wit.challenge.calculator.kafka.config;

import com.wit.challenge.calculator.kafka.consumer.CalculatorConsumerConfig;
import com.wit.challenge.calculator.kafka.producer.CalculatorProducerConfig;
import com.wit.challenge.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class CalculatorKafkaConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

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

    @Bean
    public CalculatorProducerConfig CreateCalculatorProducerConfig() {
        return new CalculatorProducerConfig();
    }

    @Bean
    public CalculatorConsumerConfig CreateCalculatorConsumerConfig(CalculatorService calculatorService, CalculatorProducerConfig calculatorProducerConfig) {
        return new CalculatorConsumerConfig(calculatorService, calculatorProducerConfig);
    }

}
