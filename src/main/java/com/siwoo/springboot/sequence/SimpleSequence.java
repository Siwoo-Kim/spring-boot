package com.siwoo.springboot.sequence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter @Setter
public class SimpleSequence {
    private String prefix;
    private int initial;
    private String suffix;
    private AtomicInteger intSequence = new AtomicInteger();

    @Autowired(required = false)
    private PrefixGenerator prefixGenerator;

    @Autowired
    private PrefixGenerator[] prefixGenerators;
    @Autowired
    private Map<String, PrefixGenerator> prefixGeneratorMap;

    public String getSequence() {
        StringBuilder sb = new StringBuilder();
        return sb.append(prefixGenerator == null ? prefix : prefixGenerator.getPrefix())
                .append(initial)
                .append(intSequence.getAndIncrement())
                .append(suffix)
                .toString();
    }
}
