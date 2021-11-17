package com.exhomework.parser;

import com.exhomework.comparator.Comparator;
import com.exhomework.comparator.FactoryMethod;
import com.exhomework.domain.ArgumentList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ReadXmlSaxParser {

    public void parse(ArgumentList argument){

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        saxFactory.setValidating(true);
        saxFactory.setNamespaceAware(false);

        FactoryMethod factoryMethod = new FactoryMethod();
        Comparator comparator = factoryMethod.comparator(argument.getSearchType(), argument);

        SaxParserHandler handler = new SaxParserHandler(comparator);

        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            File file = new File(argument.getInputFilename());

            saxParser.parse(file, handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }

    }
}
