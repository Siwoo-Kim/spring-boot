package com.siwoo.springboot.aop;

import com.siwoo.springboot.calculator.MaxCalculator;
import com.siwoo.springboot.calculator.MaxCalculatorImpl;
import com.siwoo.springboot.calculator.MinCalculator;
import com.siwoo.springboot.calculator.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EnhanceCalculatorIntroduction {

    @DeclareParents(value = "com.siwoo.springboot.calculator.ArithmeticCalculatorImpl",
    defaultImpl = MaxCalculatorImpl.class)
    private MaxCalculator maxCalculator;

    @DeclareParents(value = "com.siwoo.springboot.calculator.ArithmeticCalculatorImpl",
            defaultImpl = MinCalculatorImpl.class)
    private MinCalculator minCalculator;

}
