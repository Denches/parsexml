package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;

public class FullComparator extends Comparator {

    public FullComparator(ArgumentStore argument) {
        super(argument);
    }

    @Override
    public boolean compare(String name) {
        return true;
    }
}