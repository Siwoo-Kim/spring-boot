package com.siwoo.springboot.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    //@Pointcut("execution(* *..*Calculator*.*(..))")
    @Pointcut("arithmeticCalculatorPointcut() || unitCalculatorPointcut()")
    public void calculatorPointcut() { }

    @Pointcut("within(com.siwoo.springboot.calculator.ArithmeticCalculator+)")
    public void arithmeticCalculatorPointcut() { }

    @Pointcut("within(com.siwoo.springboot.calculator.UnitCalculator+)")
    public void unitCalculatorPointcut() { }

}
