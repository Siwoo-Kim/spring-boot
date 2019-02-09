package com.siwoo.springboot.dao;

import com.siwoo.springboot.sequence.Sequence;

public interface SequenceDao {

    Sequence getSequence(String sequenceId);
    int getNextValue(String sequenceId);

}
