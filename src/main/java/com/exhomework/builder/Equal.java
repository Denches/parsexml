package com.exhomework.builder;

import com.exhomework.TypeOfFilter;

public class Equal extends Search {
    @Override
    public boolean comparator() {

        return  name.contains(TypeOfFilter.searchType);
    }
}
