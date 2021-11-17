package com.exhomework.domain;

import com.exhomework.constant.XConstant.SearchType;

public class ArgumentList {

    private String inputFilename;
    private String mask;
    private SearchType searchType = SearchType.Full;

    public String getInputFilename() {
        return inputFilename;
    }

    public String getMask() {
        return mask;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setInputFilename(String inputFilename) {
            this.inputFilename = inputFilename;
    }

    public void setMask(String mask) {
            this.mask = mask;
    }

    public void setSearchType(SearchType searchType) {
            this.searchType = searchType;
    }
}
