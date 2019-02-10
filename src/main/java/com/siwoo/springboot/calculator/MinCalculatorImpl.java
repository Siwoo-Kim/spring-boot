package com.siwoo.springboot.calculator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinCalculatorImpl implements MinCalculator {
    private static final Logger log = LoggerFactory.getLogger(MinCalculator.class);

    @Override
    public double min(double a, double b) {
        double result = (a <= b) ? a : b;
        log.info("min({},{}) = {}", a, b, result);

        return  result;
    }
}
