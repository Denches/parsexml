package com.exhomework.Parser;

import com.exhomework.comparator.Search;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.exhomework.constant.XConstant.*;

public class SaxParserHandler extends DefaultHandler {

    private Search search;

    public SaxParserHandler(Search search){
        this.search = search;
    }

    private String currentTamName;
    private boolean isFile = false;
    private List<String> pathList = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();

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
                if (pathList.size() > 1) {

                    pathList.remove(pathList.size() - 1);
                    pathList.remove(pathList.size() - 1);
                }
            }
        }
        isFile = false;
        currentTamName = null;
        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentTamName != null){
            if (currentTamName.equals(TAG_NAME)) {
                buffer.append(ch, start, length);

                if(isFile){

                    search.setName(buffer.toString());
                    pathList.add(buffer.toString());

                    buffer.setLength(0);

                    for (String path : pathList){
                        buffer.append(path);
                    }

                    search.setDir(buffer.toString());
                    search.print();

                    pathList.remove(pathList.size() - 1);

                } else{
                    pathList.add(buffer.toString());

                    if (pathList.size() > 0) {

                        if (!pathList.get(pathList.size() - 1).equals(SPLIT_DIR)) {
                            pathList.add(SPLIT_DIR);
                        }
                    }
                }
            }
        }
    }
}

