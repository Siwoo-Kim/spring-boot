package com.siwoo.springboot.sequence;

public class SimplePrefixGenerator implements PrefixGenerator {

    @Override
    public String getPrefix() {
        return "P";
    }
}
