package com.exhomework.builder;

import com.exhomework.Parser.ReadXmlSaxParser;

import java.util.List;

public abstract class Search {

    private String dir;
    protected String name;

    public abstract boolean comparator();

    public void print(){

            if (comparator()){
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
