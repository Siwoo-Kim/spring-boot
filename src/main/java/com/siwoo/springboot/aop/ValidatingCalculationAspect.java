package com.siwoo.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class ValidatingCalculationAspect {

    //@Before("Pointcuts.arithmeticCalculatorPointcut()")
    //@Before("execution(public * *..ArithmeticCal*.*(..))")
    //@Before("execution(public * *..ArithmeticCal*.*(double, ..))")
    //@Before("execution(public * com.*..ArithmeticCal*.*(double, double))")
    //@Before("execution(public double com.*..ArithmeticCal*.*(double, double))")
    @Before("@annotation(Logging)")
    public void beforeValidate(JoinPoint jp) {
        for (Object value: jp.getArgs())
            validate((Double) value);
    }

    private void validate(Double value) {
        if (value.isNaN() || value.isInfinite() || value < 0)
            throw new IllegalArgumentException("Positive number only.");
    }
}
