package com.siwoo.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.siwoo.springboot.dao", "com.siwoo.springboot.service"},
        includeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = {"com.*dao.*DaoImpl", "com.*dao.*Service[Impl]"}
        ),
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Configuration.class}
        ))
public class DaoConfiguration {

}
