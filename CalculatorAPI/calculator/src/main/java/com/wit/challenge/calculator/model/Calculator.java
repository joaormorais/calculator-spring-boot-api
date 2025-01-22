package com.wit.challenge.calculator.model;

public class Calculator {

    public Calculator() {
    }

    /**
     * Adds 2 numbers.
     * @return result of the addition
     */
    public float sum(float number1, float number2) {
        return number1 + number2;
    }

    /**
     * Subtracts 2 numbers.
     * @return result of the subtraction
     */
    public float sub(float number1, float number2) {
        return number1 - number2;
    }

    /**
     * Multiplies 2 numbers.
     * @return result of the multiplication
     */
    public float mul(float number1, float number2) {
        return number1 * number2;
    }

    /**
     * Divides 2 numbers.
     * @return result of the division
     */
    public float div(float number1, float number2) {
        return number1 / number2;
    }

}
