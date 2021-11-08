package com.exhomework.comparator;

public abstract class AbstractComparator {

    public abstract boolean compare(String name);

    public void print(String name, String dir){

            if (compare(name)){
                System.out.println(dir);
            }
    }
}
