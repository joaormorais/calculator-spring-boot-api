package com.wit.challenge.rest.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestConsumerConfig {

    private final Map<String, CalcRequest> answersMap = new HashMap<>();

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "calculator.answer", groupId = "com.wit.challenge")
    public void consume(String message) {
        CalcRequest answer = objectMapper.convertValue(message, CalcRequest.class);
        answersMap.put(answer.getId(), answer);
    }

    public List<String> getAnswersIds() {
        List<String> ids = new ArrayList<>();
        for (Map.Entry<String, CalcRequest> entry : answersMap.entrySet())
            ids.add(entry.getKey());
        return ids;
    }

    public CalcRequest getAnswer(String id) {
        return answersMap.remove(id);
    }

}