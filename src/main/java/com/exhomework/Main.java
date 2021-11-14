package com.exhomework;

import com.exhomework.parser.ArgumentParser;
import com.exhomework.parser.ReadXmlSaxParser;
import com.exhomework.exception.ArgumentException;
import com.exhomework.domain.ArgumentList;

public class Main {

    public static void main(String[] args) {

        try {
            ArgumentList argument = new ArgumentParser(args);

            ReadXmlSaxParser readXmlSaxParser = new ReadXmlSaxParser();
            readXmlSaxParser.parse(argument);

        }catch (ArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
