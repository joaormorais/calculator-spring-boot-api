package com.wit.challenge.rest.controller;

import com.wit.challenge.CalcRequest;
import com.wit.challenge.rest.kafka.consumer.RestConsumerConfig;
import com.wit.challenge.rest.kafka.producer.RestProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static java.lang.Thread.sleep;

@RestController
public class CalculatorController {

    private static Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private final RestProducerConfig restProducerConfig;
    private final RestConsumerConfig restConsumerConfig;

    @Autowired
    public CalculatorController(RestProducerConfig restProducerConfig, RestConsumerConfig restConsumerConfig) {
        logger.info("Creating the rest controller...");
        this.restProducerConfig = restProducerConfig;
        this.restConsumerConfig = restConsumerConfig;
        logger.info("Created the rest controller.");
    }

    @GetMapping("/sum")
    public float sum(@RequestParam float a, @RequestParam float b) {
        logger.info("Received a sum request...");
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "sum", a, b);
        logger.info("Request received: " + request);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 2 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
            logger.info("Waiting for an answer...");
            if (System.currentTimeMillis() > end)
                break;

            for (String id : restConsumerConfig.getAnswersIds())
                if (id.equals(request.getId())) {
                    isAnswerFound = true;
                    answer = restConsumerConfig.getAnswer(id);
                }

            try {
                sleep(250);
            } catch (InterruptedException e) {
                logger.error("There was an error trying to sleep: " + e.getMessage(), e);
                throw new RuntimeException();
            }
        }

        logger.info(answer == null ? "Answer not found" : "Answer found" + answer.getResult());
        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/sub")
    public float sub(@RequestParam float a, @RequestParam float b) {
        logger.info("Received a sub request...");
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "sub", a, b);
        logger.info("Request received: " + request);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
            logger.info("Waiting for an answer...");
            if (System.currentTimeMillis() > end)
                break;

            for (String id : restConsumerConfig.getAnswersIds())
                if (id.equals(request.getId())) {
                    isAnswerFound = true;
                    answer = restConsumerConfig.getAnswer(id);
                }
            try {
                sleep(250);
            } catch (InterruptedException e) {
                logger.error("There was an error trying to sleep: " + e.getMessage(), e);
                throw new RuntimeException();
            }
        }

        logger.info(answer == null ? "Answer not found" : "Answer found" + answer.getResult());
        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/mul")
    public float mul(@RequestParam float a, @RequestParam float b) {
        logger.info("Received a mul request...");
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "mul", a, b);
        logger.info("Request received: " + request);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
            logger.info("Waiting for an answer...");
            if (System.currentTimeMillis() > end)
                break;

            for (String id : restConsumerConfig.getAnswersIds())
                if (id.equals(request.getId())) {
                    isAnswerFound = true;
                    answer = restConsumerConfig.getAnswer(id);
                }
            try {
                sleep(250);
            } catch (InterruptedException e) {
                logger.error("There was an error trying to sleep: " + e.getMessage(), e);
                throw new RuntimeException();
            }
        }

        logger.info(answer == null ? "Answer not found" : "Answer found" + answer.getResult());
        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/div")
    public float div(@RequestParam float a, @RequestParam float b) {
        logger.info("Received a div request...");
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "div", a, b);
        logger.info("Request received: " + request);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
            logger.info("Waiting for an answer...");
            if (System.currentTimeMillis() > end)
                break;

            for (String id : restConsumerConfig.getAnswersIds())
                if (id.equals(request.getId())) {
                    isAnswerFound = true;
                    answer = restConsumerConfig.getAnswer(id);
                }
            try {
                sleep(250);
            } catch (InterruptedException e) {
                logger.error("There was an error trying to sleep: " + e.getMessage(), e);
                throw new RuntimeException();
            }
        }

        logger.info(answer == null ? "Answer not found" : "Answer found" + answer.getResult());
        return answer == null ? Float.NaN : answer.getResult();
    }

}
