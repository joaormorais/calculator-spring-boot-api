package com.wit.challenge.rest.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class RestProducerConfig {

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
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(calculatorRequestTopic, orderAsMessage);
    }

}