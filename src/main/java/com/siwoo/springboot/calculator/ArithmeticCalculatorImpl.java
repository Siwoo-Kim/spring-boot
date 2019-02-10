package com.siwoo.springboot.calculator;

import com.siwoo.springboot.aop.Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    private static final Logger log = LoggerFactory.getLogger(ArithmeticCalculatorImpl.class);

    @Logging
    @Override
    public double add(double a, double b) {
        double result = a + b;
        log.info("{} + {} = {}", a, b, result);
        return result;
    }

    @Logging
    @Override
    public double sub(double a, double b) {
        double result = a - b;
        log.info("{} - {} = {}", a, b, result);
        return result;
    }

    @Logging
    @Override
    public double mul(double a, double b) {
        double result = a * b;
        log.info("{} * {} = {}", a, b, result);
        return result;
    }

    @Logging
    @Override
    public double div(double a, double b) {
        if (b == 0.0D)
            throw new IllegalArgumentException("Division by zero.");
        double result = a / b;
        log.info("{} / {} = {}", a, b, result);
        return result;
    }
}
