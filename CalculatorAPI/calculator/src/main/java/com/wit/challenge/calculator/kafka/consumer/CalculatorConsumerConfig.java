package com.wit.challenge.calculator.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import com.wit.challenge.calculator.kafka.producer.CalculatorProducerConfig;
import com.wit.challenge.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorConsumerConfig {

    private final CalculatorService calculatorService;
    private final CalculatorProducerConfig calculatorProducerConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public CalculatorConsumerConfig(CalculatorService calculatorService, CalculatorProducerConfig calculatorProducerConfig) {
        this.calculatorService = calculatorService;
        this.calculatorProducerConfig = calculatorProducerConfig;
    }

    @KafkaListener(topics = "calculator.request", groupId = "com.wit.challenge")
    public void consume(String message) {
        CalcRequest request;
        try {
            request = objectMapper.readValue(message, CalcRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        switch (request.getOperation()) {
            case "sum":
                request.setResult(calculatorService.sum(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "sub":
                request.setResult(calculatorService.sub(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "mul":
                request.setResult(calculatorService.mul(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
            case "div":
                request.setResult(calculatorService.div(request.getA(), request.getB()));
                calculatorProducerConfig.sendMessage(request);
                break;
        }
    }

}
