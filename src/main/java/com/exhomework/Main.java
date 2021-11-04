package com.exhomework;

import com.exhomework.Parser.ArgumentParser;
import com.exhomework.Parser.ReadXmlSaxParser;

public class Main {

    public static void main(String[] args) {

        new ArgumentParser(args);

        ReadXmlSaxParser readXmlSaxParser = new ReadXmlSaxParser();
        readXmlSaxParser.parse();
    }
}
