package com.siwoo.springboot.config;

import com.siwoo.springboot.sequence.DatePrefixGenerator;
import com.siwoo.springboot.sequence.PrefixGenerator;
import com.siwoo.springboot.sequence.SimplePrefixGenerator;
import com.siwoo.springboot.sequence.SimpleSequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SequenceConfiguration {

    @Bean
    @Primary
    public PrefixGenerator datePrefixGenerator() {
        PrefixGenerator prefix = new DatePrefixGenerator("yyyyMMdd");
        return prefix;
    }

    @Bean
    public PrefixGenerator simplePrefixGenerator() {
        PrefixGenerator prefix = new SimplePrefixGenerator();
        return prefix;
    }

    @Bean
    public SimpleSequence sequence() {
        SimpleSequence seq = new SimpleSequence();
        //seq.setPrefixGenerator(datePrefixGenerator());
        seq.setSuffix("A");
        seq.setInitial(100000);
        return seq;
    }

}
