package com.wit.challenge.rest.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import com.wit.challenge.rest.controller.CalculatorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class RestProducerConfig {

    private static final Logger logger = LoggerFactory.getLogger(RestProducerConfig.class);

    @Value("${topics.calculator.request}")
    private String calculatorRequestTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(CalcRequest calcRequest) {
        String orderAsMessage;
        try {
            orderAsMessage = objectMapper.writeValueAsString(calcRequest);
        } catch (JsonProcessingException e) {
            logger.error("There was an error converting the calculator request to JSON: " + e.getMessage(), e);
            throw new RuntimeException();
        }
        logger.info("Sending a request to execute a calculation to topic: " + calculatorRequestTopic);
        kafkaTemplate.send(calculatorRequestTopic, orderAsMessage);
    }

}