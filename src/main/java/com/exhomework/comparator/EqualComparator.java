package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;

public class EqualComparator extends Comparator {

    protected EqualComparator(ArgumentList argument) {
        super(argument);
    }

    @Override
    public boolean compare(String filename) {
        return argument.getMask().equals(filename);
    }
}