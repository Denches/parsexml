package com.exhomework.parser;

import com.exhomework.domain.PathToFilePrinter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static com.exhomework.constant.XConstant.*;

public class SaxParserHandler extends DefaultHandler {

    private PathToFilePrinter path;

    public SaxParserHandler(PathToFilePrinter path){
        this.path = path;
    }

    private boolean active;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        if (qName.equalsIgnoreCase(TAG_CHILD)) {
            path.setFile(Boolean.parseBoolean(attributes.getValue(IS_FILE)));
        }
        active = qName.equals(TAG_NAME);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals(TAG_NAME)){
            active = false;
        }

        if(TAG_CHILDREN.equals(qName)){
            path.closeDir();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (active) {
            path.store(new String(ch, start, length));
        }
    }
}