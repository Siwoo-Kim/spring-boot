package com.siwoo.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    //@Before("execution(* com.*..*Calculator.*(..))")
    @Before("Pointcuts.calculatorPointcut()")
    public void logJoinPoint(JoinPoint jp) {
        log.info("Signature Name; {}", jp.getSignature().getName());
        log.info("Target type; {}", jp.getSignature().getDeclaringType());
        log.info("Args; {}", Arrays.toString(jp.getArgs()));
        log.info("Proxy; {}", jp.getThis());
        log.info("Proxy's target; {}", jp.getTarget());
    }

    //@Around("execution(* com.*..*Calculator.*(..))")
    @Around("Pointcuts.calculatorPointcut()")
    public Object aroundLogging(ProceedingJoinPoint jp) throws Throwable {
        log.info("Before calling {} with args", jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        try {
            Object result = jp.proceed();
            log.info("After calling {} with args, result {}", jp.getSignature().getName(), result);
            return result;
        } catch (Throwable e) {
            log.info("Exception e has bean thrown in {}", e, jp.getSignature().getName());
            throw e;
        }
    }
//    @Before("execution(* com.*..*Calculator*.*(..))")
//    public void beforeLog(JoinPoint jp) {
//        log.info("Before calling {} with args", jp.getSignature(), Arrays.toString(jp.getArgs()));
//    }
//
//    @After("execution(* *..*Calculator*.div(double, double))")
//    public void afterLog(JoinPoint jp) {
//        log.info("After calling {}", jp.getSignature().getName());
//    }
//
//    @AfterReturning(value = "execution(double *..*Calculator*.div(double, double))", returning = "result")
//    public void afterReturningLog(JoinPoint jp, double result) {
//        log.info("After Returning  calling {}, result {}", jp.getSignature().getName(), result);
//    }
//
//    @AfterThrowing(value = "execution(* *..*Calculator*.div(..))", throwing = "e")
//    public void afterThrowing(JoinPoint jp, IllegalArgumentException e) {
//        log.info("Exception {} has bean thrown in {}", e, jp.getSignature().getName());
//    }
}
