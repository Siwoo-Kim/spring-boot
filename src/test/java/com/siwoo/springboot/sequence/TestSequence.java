package com.siwoo.springboot.sequence;

import com.siwoo.springboot.config.SequenceConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSequence {

    ApplicationContext c;

    @Before
    public void init() {
        c = new AnnotationConfigApplicationContext(SequenceConfiguration.class);
    }

    @Test
    public void testSequence() {
        SimpleSequence seq = c.getBean(SimpleSequence.class);
        assertThat(seq.getSequence()).matches("[0-9]+1000000A");
        assertThat(seq.getSequence()).matches("[0-9]+1000001A");
    }

    @Test
    public void testPrefixGenerator() {
        SimpleSequence seq = c.getBean(SimpleSequence.class);
        for (PrefixGenerator gen: seq.getPrefixGenerators()) {
            System.out.println(gen.getPrefix());
        }
        assertThat(Arrays.asList(seq.getPrefixGenerators())).contains(
                c.getBean(SimplePrefixGenerator.class),
                c.getBean(DatePrefixGenerator.class));
        assertThat(seq.getPrefixGeneratorMap().get("simplePrefixGenerator")).isNotNull();
        assertThat(seq.getPrefixGeneratorMap().get("datePrefixGenerator")).isNotNull();
    }
}
