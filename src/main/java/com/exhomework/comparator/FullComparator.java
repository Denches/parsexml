package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;

public class FullComparator extends Comparator {

    public FullComparator(ArgumentList argument) {
        super(argument);
    }

    @Override
    public boolean compare(String name) {
        return true;
    }
}