package com.wit.challenge.rest.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wit.challenge.CalcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestConsumerConfig {

    private static Logger logger = LoggerFactory.getLogger(RestConsumerConfig.class);
    private final Map<String, CalcRequest> answersMap = new HashMap<>();

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "calculator.answer", groupId = "com.wit.challenge")
    public void consume(String message) {
        logger.info("Received message... (topic: calculator.answer)");
        CalcRequest answer;
        try {
            answer = objectMapper.readValue(message, CalcRequest.class);
            logger.info("Message received (topic: calculator.answer): " + answer);
        } catch (JsonProcessingException e) {
            logger.error("There was an error reading the JSON message: " + e.getMessage(), e);
            throw new RuntimeException();
        }

        // save the answer received on the map
        answersMap.put(answer.getId(), answer);
    }

    /**
     * Getter for the keys of the map.
     * @return Ids of the answers.
     */
    public List<String> getAnswersIds() {
        List<String> ids = new ArrayList<>();
        logger.info("Searching ids for every message...");
        for (Map.Entry<String, CalcRequest> entry : answersMap.entrySet())
            ids.add(entry.getKey());
        logger.info("Returning " + ids.size() + " ids.");
        return ids;
    }

    /**
     * Getter for a value with id. After returning the object, that object is removed from the map.
     * @param id Key of the value
     * @return Request with a specific id.
     */
    public CalcRequest getAnswer(String id) {
        logger.info("Returned and deleted the answer with id: " + id);
        return answersMap.remove(id);
    }

}