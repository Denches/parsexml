package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;
import com.exhomework.domain.FileStore;

public abstract class Comparator extends FileStore {

    ArgumentStore argument;

    public Comparator(ArgumentStore argument) {
        this.argument = argument;
    }

    public void store(String name){
        super.store(name, compare(name));
    }

    public abstract boolean compare(String filename);
}