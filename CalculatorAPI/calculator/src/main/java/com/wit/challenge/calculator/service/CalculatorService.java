package com.wit.challenge.calculator.service;

import com.wit.challenge.calculator.model.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    private Calculator calculator;

    public CalculatorService() {
        calculator = new Calculator();
    }

    /**
     * Adds 2 numbers.
     * @return result of the addition
     */
    public float sum(float number1, float number2) {
        logger.info("Calculating the sum of " + number1 + " and " + number2);
        return calculator.sum(number1, number2);
    }

    /**
     * Subtracts 2 numbers.
     * @return result of the subtraction
     */
    public float sub(float number1, float number2) {
        logger.info("Calculating the sub of " + number1 + " and " + number2);
        return calculator.sub(number1, number2);
    }

    /**
     * Multiplies 2 numbers.
     * @return result of the multiplication
     */
    public float mul(float number1, float number2) {
        logger.info("Calculating the multiply of " + number1 + " and " + number2);
        return calculator.mul(number1, number2);
    }

    /**
     * Divides 2 numbers.
     * @return result of the division
     */
    public float div(float number1, float number2) {
        logger.info("Calculating the div of " + number1 + " and " + number2);
        return calculator.div(number1, number2);
    }

}
