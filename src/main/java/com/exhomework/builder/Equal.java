package com.exhomework.builder;

import com.exhomework.TypeOfFilter;

public class Equal extends Search {
    @Override
    public boolean filter(String name) {

        return  name.contains(TypeOfFilter.searchType);
    }
}
