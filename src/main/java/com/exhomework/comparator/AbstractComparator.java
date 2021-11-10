package com.exhomework.comparator;

public abstract class AbstractComparator {

    public abstract boolean compare(String filename);

    public void print(String filename, String dir){

            if (compare(filename)){
                System.out.println(dir + filename);
            }
    }
}
