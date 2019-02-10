package com.siwoo.springboot.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("unitCalculator")
public class UnitCalculatorImpl implements UnitCalculator {

    private static final Logger log = LoggerFactory.getLogger(UnitCalculatorImpl.class);

    @Override
    public double kilogramToPound(double kilogram) {
        double result = kilogram * 2.2D;
        log.info("kilogram {} = {} pound", kilogram, result);
        return result;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        double result = kilometer * 0.62D;
        log.info("kilometer {} = {} mile", kilometer, result);
        return result;
    }
}
