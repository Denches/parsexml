package com.exhomework;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ReadXmlSaxParser readXmlSaxParser = new ReadXmlSaxParser();

        String fileName = null;

        if (args[0].equals("-f")){
            fileName = args[1];
        }

        if (args.length > 2 && args[2].equals("-s")){
            Filter.setFilter(args[3]);
        }

        List<String> pathList = readXmlSaxParser.parse(fileName);

        Filter.search(pathList);

    }
}
