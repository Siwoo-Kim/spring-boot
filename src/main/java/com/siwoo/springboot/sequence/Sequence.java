package com.siwoo.springboot.sequence;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
public class Sequence {
    private String id;
    private String prefix;
    private String suffix;

    public Sequence() {
    }

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
