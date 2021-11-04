package com.exhomework.Parser;

import com.exhomework.TypeOfFilter;
import com.exhomework.comparator.ComparatorFactory;
import com.exhomework.comparator.Search;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ReadXmlSaxParser {

    public void parse(){

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        ComparatorFactory builderComparator = new ComparatorFactory();
        Search search = builderComparator.comparator(TypeOfFilter.argForPrint());

        SaxParserHandler handler = new SaxParserHandler(search);

        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            File file = new File(ArgumentParser.getInputFileName());

            saxParser.parse(file, handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }

    }
}
