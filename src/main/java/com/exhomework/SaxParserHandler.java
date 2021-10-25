package com.exhomework;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {

    private static final String TAG_CHILDREN = "children";
    private static final String TAG_CHILD = "child";
    private static final String TAG_NAME = "name";

    private String currentTamName;
    private String fileName;
    private String dir;

    private List<String> pathList = new ArrayList<>();
    private List<String> paths = new ArrayList<>();

    private boolean isFile = false;

    public List<String> getPaths(){
        return paths;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        currentTamName = qName;

        if (currentTamName.equalsIgnoreCase(TAG_CHILD)) {

            isFile = Boolean.parseBoolean(attributes.getValue("is-file"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        currentTamName = qName;

        if (currentTamName != null){
            if(currentTamName.equals(TAG_CHILDREN)){

                pathList.remove(pathList.size() - 1);
            }
        }

        isFile = false;
        currentTamName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        if (currentTamName != null) {
            if (currentTamName.equals(TAG_NAME)) {
                if (isFile) {

                    fileName = new String(ch, start, length);
                    pathList.add(fileName);

                    StringBuilder builder = new StringBuilder();

                    for (String path : pathList){
                        builder.append(path);
                    }
                    paths.add(builder.toString());

                    pathList.remove(pathList.size() - 1);

                } else {
                    dir = new String(ch, start, length);

                    if (!dir.equals("/")){
                        pathList.add(dir + "/");
                    } else{
                        pathList.add(dir);
                    }
                }
            }
        }
    }
}
