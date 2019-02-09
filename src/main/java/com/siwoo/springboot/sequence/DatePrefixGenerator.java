package com.siwoo.springboot.sequence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePrefixGenerator implements PrefixGenerator {
    private DateTimeFormatter formatter;

    public DatePrefixGenerator(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String getPrefix() {
        return LocalDate.now().format(formatter);
    }
}
