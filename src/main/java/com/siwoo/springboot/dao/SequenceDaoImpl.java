package com.siwoo.springboot.dao;


import com.siwoo.springboot.sequence.Sequence;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

    private Map<String, Sequence> sequenceMap;
    private Map<String, AtomicInteger> valueMap;

    public SequenceDaoImpl() {
        sequenceMap = new HashMap<>();
        valueMap = new HashMap<>();
        sequenceMap.put("IT", new Sequence("IT", "30", "A"));
        sequenceMap.put("HR", new Sequence("HR", "88", "H"));
        valueMap.put("IT", new AtomicInteger(10000));
        valueMap.put("HR", new AtomicInteger(20000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequenceMap.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        return valueMap.get(sequenceId).getAndIncrement();
    }
}
