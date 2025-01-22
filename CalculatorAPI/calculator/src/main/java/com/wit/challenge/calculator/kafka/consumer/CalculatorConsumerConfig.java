package com.wit.challenge.calculator.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import com.wit.challenge.calculator.kafka.producer.CalculatorProducerConfig;
import com.wit.challenge.calculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorConsumerConfig {

    private static Logger logger = LoggerFactory.getLogger(CalculatorConsumerConfig.class);
    private final CalculatorService calculatorService;
    private final CalculatorProducerConfig calculatorProducerConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public CalculatorConsumerConfig(CalculatorService calculatorService, CalculatorProducerConfig calculatorProducerConfig) {
        logger.info("Creating the consumer...");
        this.calculatorService = calculatorService;
        this.calculatorProducerConfig = calculatorProducerConfig;
        logger.info("Created the consumer.");
    }

    @KafkaListener(topics = "calculator.request", groupId = "com.wit.challenge")
    public void consume(String message) {
        logger.info("Received a message... (topic: calculator.request)");
        CalcRequest request;
        try {
            request = objectMapper.readValue(message, CalcRequest.class);
            logger.info("Message received (topic: calculator.request): " + request);
        } catch (JsonProcessingException e) {
            logger.error("There was an error reading the JSON message: " + e.getMessage(), e);
            throw new RuntimeException();
        }

        switch (request.getOperation()) {
            case "sum":
                logger.info("Received an addition request. Calculating the addition...");
                request.setResult(calculatorService.sum(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "sub":
                logger.info("Received a subtraction request. Calculating the subtraction...");
                request.setResult(calculatorService.sub(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "mul":
                logger.info("Received a multiplication request. Calculating the multiplication...");
                request.setResult(calculatorService.mul(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "div":
                logger.info("Received a division request. Calculating the division...");
                request.setResult(calculatorService.div(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
        }
    }

}
