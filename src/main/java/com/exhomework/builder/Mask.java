package com.exhomework.builder;

import com.exhomework.TypeOfFilter;

public class Mask extends Search{
    @Override
    public boolean comparator() {

        return name.matches("." + TypeOfFilter.searchType);
    }
}
