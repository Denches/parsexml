package com.exhomework.Parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadXmlSaxParser {

    public List<String> parse(){

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();

        try {
            SAXParser saxParser = factory.newSAXParser();
            File file = new File(ArgumentParser.getInputFileName());

            saxParser.parse(file, handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        return handler.getPaths();
    }
}
