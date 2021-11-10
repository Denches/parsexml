package com.exhomework.Parser;

import com.exhomework.TypeOfFilter;
import com.exhomework.comparator.FactoryComparator;
import com.exhomework.comparator.AbstractComparator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ReadXmlSaxParser {

    public void parse(){

        SAXParserFactory saxFactory = SAXParserFactory.newInstance();

        saxFactory.setValidating(true);
        saxFactory.setNamespaceAware(false);

        FactoryComparator factoryComparator = new FactoryComparator();
        AbstractComparator comparator = factoryComparator.comparator(TypeOfFilter.getSearchType());

        SaxParserHandler handler = new SaxParserHandler(comparator);

        try {
            SAXParser saxParser = saxFactory.newSAXParser();
            File file = new File(ArgumentParser.getInputFileName());

            saxParser.parse(file, handler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }

    }
}
