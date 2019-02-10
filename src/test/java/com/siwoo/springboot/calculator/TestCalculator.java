package com.siwoo.springboot.calculator;

import com.siwoo.springboot.config.CalculationConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestCalculator {

    private ApplicationContext c;

    @Before
    public void init() {
        c = new AnnotationConfigApplicationContext(CalculationConfiguration.class);
        for (String beanName: c.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

    @Test
    public void test() {

    }

//    @Test
//    public void testWeaving() {
//        ComplexCalculator complexCalculator = c.getBean(ComplexCalculator.class);
//        complexCalculator.add(new Complex(1, 2), new Complex(2, 3));
//        complexCalculator.add(new Complex(5, 8), new Complex(2, 3));
//    }

    @Test
    public void testBeforeAdvice() {
        ArithmeticCalculator arithCal = c.getBean(ArithmeticCalculator.class);
        //arithCal.add(0, -10);
        arithCal.add(10, 10);
        arithCal.sub(10, 10);
        arithCal.mul(10, 10);
        arithCal.div(10, 10);

        UnitCalculator unitCal = c.getBean(UnitCalculator.class);
        unitCal.kilogramToPound(10);
        unitCal.kilometerToMile(10);
        //arithCal.div(10, 0);

        MaxCalculator maxCalculator = (MaxCalculator) arithCal;
        maxCalculator.max(10, 5);
        MinCalculator minCalculator = (MinCalculator) arithCal;
        minCalculator.min(10, 5);
    }
}
