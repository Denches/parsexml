package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;

public abstract class Comparator {

    ArgumentList argument;

    protected Comparator(ArgumentList argument) {
        this.argument = argument;
    }

    public abstract boolean compare(String filename);
}