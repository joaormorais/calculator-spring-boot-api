package com.wit.challenge.calculator.service;

import com.wit.challenge.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorService calculatorService;

    @Mock
    Calculator calculator;

    @Test
    public void calculateSum() {
        calculator = new Calculator();
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedSum = a + b;

        when(calculatorService.sum(a, b)).thenReturn(calculator.sum(a, b));
        assertThat(calculatorService.sum(a, b)).isEqualTo(expectedSum);
    }

    @Test
    public void calculateSub() {
        calculator = new Calculator();
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedSub = a - b;

        when(calculatorService.sub(a, b)).thenReturn(calculator.sub(a, b));
        assertThat(calculatorService.sub(a, b)).isEqualTo(expectedSub);
    }

    @Test
    public void calculateMul() {
        calculator = new Calculator();
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedMul = a * b;

        when(calculatorService.mul(a, b)).thenReturn(calculator.mul(a, b));
        assertThat(calculatorService.mul(a, b)).isEqualTo(expectedMul);
    }

    @Test
    public void calculateDiv() {
        calculator = new Calculator();
        Random rand = new Random();
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float expectedDiv = a / b;

        when(calculatorService.div(a, b)).thenReturn(calculator.div(a, b));
        assertThat(calculatorService.div(a, b)).isEqualTo(expectedDiv);
    }

}
