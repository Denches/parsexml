package com.exhomework.Parser;

import com.exhomework.comparator.AbstractComparator;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.exhomework.constant.XConstant.*;

public class SaxParserHandler extends DefaultHandler {

    private AbstractComparator comparator;

    public SaxParserHandler(AbstractComparator comparator){
        this.comparator = comparator;
    }

    private String currentTamName;
    private String name;
    private boolean isFile = false;
    private List<String> dir = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        currentTamName = qName;

        if (currentTamName.equalsIgnoreCase(TAG_CHILD)) {

            isFile = Boolean.parseBoolean(attributes.getValue(IS_FILE));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        currentTamName = qName;

        if (currentTamName != null){
            if(currentTamName.equals(TAG_CHILDREN)){
                if (dir.size() > 1) {

                    dir.remove(dir.size() - 1);
                    dir.remove(dir.size() - 1);
                }
            }
        }
        currentTamName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentTamName != null){
            if (currentTamName.equals(TAG_NAME)) {
                name = new String(ch, start, length);

                if(isFile){
                    comparator.print(name, getCurDir());
                } else{
                    dir.add(name);

                    if (!name.equals(SPLIT_DIR)){
                        dir.add(SPLIT_DIR);
                    }
                }
            }
        }
    }

    private String getCurDir() {
        return dir.stream()
                .filter(e -> !equals(""))
                .collect(Collectors.joining());
    }
}