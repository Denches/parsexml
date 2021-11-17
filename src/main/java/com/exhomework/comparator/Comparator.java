package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import com.exhomework.domain.FileStore;

public abstract class Comparator extends FileStore {

    ArgumentList argument;

    public Comparator(ArgumentList argument) {
        this.argument = argument;
    }

    public void store(String name){

        if(isFile()){
            if (compare(name)){
                print(name, getCurDir());
            }
        } else{
            setDir(name);
        }
    }

    public abstract boolean compare(String filename);
}