package com.siwoo.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.siwoo.springboot",
    useDefaultFilters = false,
    includeFilters = {
        @ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = "com.siwoo.springboot.calculator.[a-zA-Z]+Calculator([a-zA-Z]+)?"),
        @ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = "com.siwoo.springboot.aop.[a-zA-Z]+(Aspect|Introduction)([a-zA-Z]+)?")
    })
public class CalculationConfiguration {

}
