package com.exhomework.Parser;

import com.exhomework.model.Node;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import static com.exhomework.constant.XConstant.*;

public class SaxParserHandler extends DefaultHandler {

    private String currentTamName;
    private Node node;
    private List<Node> children;
    private Node child;
    private Node lastChild;

    private StringBuilder buffer = new StringBuilder();

    public List<String> paths = new ArrayList<>();
    public List<String> getPaths(){ return paths; }
    public List<String> pathList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {

        currentTamName = qName;

        if (currentTamName.equals(TAG_NODE)){
            node = new Node();
            child = node;
            lastChild = node;
            child.setIsFile(Boolean.parseBoolean(attributes.getValue(IS_FILE)));
        }

        if (currentTamName.equals(TAG_CHILDREN)) {
            children = new ArrayList<>();
            child.setChildren(children);
        }
        if (currentTamName.equals(TAG_CHILD)){
            child = new Node();

            child.setIsFile(Boolean.parseBoolean(attributes.getValue(IS_FILE)));

            if (!child.isFile()){
                child.setPrevious(lastChild);
                lastChild = child;
            }

            children.add(child);
        }

        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals(TAG_NAME)){
            child.setName(buffer.toString());
            pathList.add(child.getName());
            if (child.isFile()){

                StringBuilder builder = new StringBuilder();

                for (String s : pathList){
                    builder.append(s);

                }
                paths.add(builder.toString());
                pathList.remove(pathList.size()-1);
            }else {
                if (pathList.size()>1)
                pathList.add(SPLIT_DIR);
            }

        }else if (qName.equals(TAG_CHILDREN)){
            child = lastChild.getPrevious();
            lastChild = child;

            if (child != null){
                children = child.getChildren();
                IntStream.range(0, 2).forEach(i -> pathList.remove(pathList.size() - 1));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {

        if (currentTamName.equals(TAG_NAME)){
            buffer.append(new String(ch,start,length).trim());
        }
    }
}

