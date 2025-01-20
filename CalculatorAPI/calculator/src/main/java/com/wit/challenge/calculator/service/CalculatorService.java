package com.wit.challenge.calculator.service;

import com.wit.challenge.calculator.model.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private Calculator calculator;

    public CalculatorService() {
        calculator = new Calculator();
    }

    //TODO: adicioar uma escuta a um topico (request.calc) que vai eviar mensagens a idetificar a operação e a madar 2 numeros
    // funçao com switch para determiar qual calculo fazer
    // responder para um novo topico (aswer.calc)

    public float sum(float number1, float number2) {
        return calculator.sum(number1, number2);
    }

    public float sub(float number1, float number2) {
        return calculator.sub(number1, number2);
    }

    public float mul(float number1, float number2) {
        return calculator.mul(number1, number2);
    }

    public float div(float number1, float number2) {
        return calculator.div(number1, number2);
    }

}
