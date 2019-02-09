package com.siwoo.springboot.dao;

import com.siwoo.springboot.config.DaoConfiguration;
import com.siwoo.springboot.service.SequenceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSequenceDao {

    ApplicationContext c;

    @Before
    public void init() {
        c = new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Test
    public void testDao() {
        SequenceDao seqDao = c.getBean(SequenceDao.class);
        assertThat(seqDao.getNextValue("IT")).isEqualTo(10000);
        assertThat(seqDao.getNextValue("IT")).isEqualTo(10001);
        assertThat(seqDao.getNextValue("HR")).isEqualTo(20000);
        assertThat(seqDao.getNextValue("HR")).isEqualTo(20001);

        for (String beanName: c.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

    @Test
    public void testService() {
        SequenceService seqService = c.getBean(SequenceService.class);
        assertThat(seqService.generate("IT")).isEqualTo("3010000A");
        assertThat(seqService.generate("IT")).isEqualTo("3010001A");
        assertThat(seqService.generate("HR")).isEqualTo("8820000H");
        assertThat(seqService.generate("HR")).isEqualTo("8820001H");
    }

}
