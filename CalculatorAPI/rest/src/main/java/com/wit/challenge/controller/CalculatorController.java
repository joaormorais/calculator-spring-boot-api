package com.wit.challenge.controller;

import com.wit.challenge.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private CalculatorService calculatorService; // TODO: remover depois de introduzir o kafka

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sum")
    public float sum(@RequestParam float a, @RequestParam float b) {
            return calculatorService.sum(a, b); // TODO: eviar mesagem para o topico que o calculator vai estar a escutar
    }

    @GetMapping("/sub")
    public float sub(@RequestParam float a, @RequestParam float b) {
            return calculatorService.sub(a, b); // TODO: eviar mesagem para o topico que o calculator vai estar a escutar
    }

    @GetMapping("/mul")
    public float mul(@RequestParam float a, @RequestParam float b) {
            return calculatorService.mul(a, b); // TODO: eviar mesagem para o topico que o calculator vai estar a escutar
    }

    @GetMapping("/div")
    public float div(@RequestParam float a, @RequestParam float b) {
            return calculatorService.div(a, b); // TODO: eviar mesagem para o topico que o calculator vai estar a escutar
    }

}
