package com.siwoo.springboot.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MaxCalculatorImpl implements MaxCalculator {
        private static final Logger log = LoggerFactory.getLogger(MaxCalculator.class);

        @Override
        public double max(double a, double b) {
                double result = (a >= b) ? a : b;
                log.info("max({},{}) = {}", a, b, result);
                return  result;
        }
}
