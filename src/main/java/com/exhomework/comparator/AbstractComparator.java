package com.exhomework.comparator;

public abstract class AbstractComparator {

    private String dir;
    protected String name;

    public abstract boolean compare();

    public void print(){

            if (compare()){
                System.out.println(dir);
            }
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setName(String name) {
        this.name = name;
    }
}
