package com.wit.challenge.calculator.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CalculatorProducerConfig {

    @Value("${topics.calculator.answer}")
    private String calculatorAnswerTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(CalcRequest calcRequest) {
        String orderAsMessage = objectMapper.convertValue(calcRequest, String.class);
        kafkaTemplate.send(calculatorAnswerTopic, orderAsMessage);
    }
}
