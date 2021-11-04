package com.exhomework;

import com.exhomework.Parser.ArgumentParser;
import com.exhomework.comparator.SearchType;

public class TypeOfFilter {

    public static final String searchType = ArgumentParser.getMask();

    public static SearchType getSearchType(){

        if (searchType == null) {
            return SearchType.Full;
        }

        if (searchType.contains("*.")){
            return SearchType.Mask;
        } else if(searchType.contains("file")){
            return SearchType.Equals;
        } else if(searchType.contains(".*")){
            return SearchType.Regular;
        }

        return SearchType.Full;
    }
}
