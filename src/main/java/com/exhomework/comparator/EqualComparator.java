package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;

public class EqualComparator extends Comparator {

    public EqualComparator(ArgumentStore argument) {
        super(argument);
    }

    @Override
    public boolean compare(String filename) {
        return argument.getMask().equals(filename);
    }
}