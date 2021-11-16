package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import com.exhomework.domain.FileStore;

public abstract class Comparator extends FileStore {

    ArgumentList argument;

    protected Comparator(ArgumentList argument) {
        this.argument = argument;
    }

    public abstract boolean compare(String filename);
}