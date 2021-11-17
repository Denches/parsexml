package com.exhomework.domain;

import com.exhomework.constant.XConstant.SearchType;

public class ArgumentList {

    private String pathToFilename;
    private String filename;
    private String mask;
    private SearchType searchType = SearchType.Full;

    public String getPathToFilename() {
        return pathToFilename;
    }

    public String getMask() {
        return mask;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setpathToFilename(String pathToFilename) {
            this.pathToFilename = pathToFilename;
    }

    public void setMask(String mask) {
            this.mask = mask;
    }

    public void setSearchType(SearchType searchType) {
            this.searchType = searchType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
