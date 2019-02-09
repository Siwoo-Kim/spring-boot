package com.siwoo.springboot.service;

import com.siwoo.springboot.dao.SequenceDao;
import com.siwoo.springboot.sequence.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    public String generate(String sequenceId) {
        Sequence seq = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return seq.getPrefix() + value + seq.getSuffix();
    }

}
