package com.wit.challenge.rest.controller;

import com.wit.challenge.CalcRequest;
import com.wit.challenge.rest.kafka.consumer.RestConsumerConfig;
import com.wit.challenge.rest.kafka.producer.RestProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static java.lang.Thread.sleep;

@RestController
public class CalculatorController {

    private final RestProducerConfig restProducerConfig;
    private final RestConsumerConfig restConsumerConfig;

    @Autowired
    public CalculatorController(RestProducerConfig restProducerConfig, RestConsumerConfig restConsumerConfig) {
        this.restProducerConfig = restProducerConfig;
        this.restConsumerConfig = restConsumerConfig;
    }

    @GetMapping("/sum")
    public float sum(@RequestParam float a, @RequestParam float b) {
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "sum", a, b);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 2 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
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
                throw new RuntimeException(e);
            }
        }

        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/sub")
    public float sub(@RequestParam float a, @RequestParam float b) {
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "sub", a, b);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
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
                throw new RuntimeException(e);
            }
        }

        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/mul")
    public float mul(@RequestParam float a, @RequestParam float b) {
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "mul", a, b);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
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
                throw new RuntimeException(e);
            }
        }

        return answer == null ? Float.NaN : answer.getResult();
    }

    @GetMapping("/div")
    public float div(@RequestParam float a, @RequestParam float b) {
        CalcRequest request = new CalcRequest(UUID.randomUUID().toString(), "div", a, b);
        restProducerConfig.sendMessage(request);

        long start = System.currentTimeMillis();
        long end = start + 6 * 1000;
        CalcRequest answer = null;
        boolean isAnswerFound = false;

        while (!isAnswerFound) {
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
                throw new RuntimeException(e);
            }
        }

        return answer == null ? Float.NaN : answer.getResult();
    }

}
