package com.wit.challenge.rest.controller;

import com.wit.challenge.rest.kafka.consumer.RestConsumerConfig;
import com.wit.challenge.rest.kafka.producer.RestProducerConfig;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @InjectMocks
    CalculatorController calculatorController;

    @Mock
    RestProducerConfig restProducerConfig;

    @Mock
    RestConsumerConfig restConsumerConfig;

    @Test
    public void sumEndpointTest() throws Exception {
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedSum = a + b;

        //TODO: try to quit the cicle where the answers are being search. the return is NaN because there isn't a list with id's in order to find the answer
        //when(restConsumerConfig.getAnswersIds()).thenReturn()

        assertThat(calculatorController.sum(a, b)).isEqualTo(expectedSum);

    }

    @Test
    public void subEndpointTest() throws Exception {
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedSub = a - b;

        //TODO: try to quit the cicle where the answers are being search. the return is NaN because there isn't a list with id's in order to find the answer
        //when(restConsumerConfig.getAnswersIds()).thenReturn()

        assertThat(calculatorController.sub(a, b)).isEqualTo(expectedSub);
    }

    @Test
    public void multiplyEndpointTest() throws Exception {
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedMultiply = a * b;

        //TODO: try to quit the cicle where the answers are being search. the return is NaN because there isn't a list with id's in order to find the answer
        //when(restConsumerConfig.getAnswersIds()).thenReturn()

        assertThat(calculatorController.mul(a, b)).isEqualTo(expectedMultiply);
    }

    @Test
    public void divideEndpointTest() throws Exception {
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedDivide = a / b;

        //TODO: try to quit the cicle where the answers are being search. the return is NaN because there isn't a list with id's in order to find the answer
        //when(restConsumerConfig.getAnswersIds()).thenReturn()

        assertThat(calculatorController.div(a, b)).isEqualTo(expectedDivide);
    }

}
