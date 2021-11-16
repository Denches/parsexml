package com.exhomework.parser;

import com.exhomework.comparator.Comparator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static com.exhomework.constant.XConstant.*;

public class SaxParserHandler extends DefaultHandler {

    private Comparator comparator;

    public SaxParserHandler(Comparator comparator){
        this.comparator = comparator;
    }

    private boolean active;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        if (TAG_CHILD.equalsIgnoreCase(qName)) {
            comparator.setFile(Boolean.parseBoolean(attributes.getValue(IS_FILE)));
        }
        active = TAG_NAME.equals(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        switch(qName){
            case TAG_NAME -> active = false;
            case TAG_CHILDREN -> comparator.closeDir();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (active) {
            comparator.store(new String(ch, start, length));
        }
    }
}