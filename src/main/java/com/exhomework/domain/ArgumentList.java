package com.exhomework.domain;

import com.exhomework.constant.XConstant.SearchType;

public abstract class ArgumentList {

    private String inputFileName;
    private String mask;
    private SearchType searchType = SearchType.Full;

    public String getInputFileName() {
        return inputFileName;
    }

    public String getMask() {
        return mask;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }
}
