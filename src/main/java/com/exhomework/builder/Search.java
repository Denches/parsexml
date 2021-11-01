package com.exhomework.builder;

import com.exhomework.Parser.ReadXmlSaxParser;

import java.util.List;

public abstract class Search {

    ReadXmlSaxParser readXmlSaxParser = new ReadXmlSaxParser();

    public List<String> paths = readXmlSaxParser.parse();

    public abstract boolean filter(String name);

    public void print(){
        for (String s : paths) {
            if (filter(s)){
                System.out.println(s);
            }

        }
    }
}
