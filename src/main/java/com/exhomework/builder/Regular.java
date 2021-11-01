package com.exhomework.builder;

import com.exhomework.TypeOfFilter;

public class Regular extends Search {

    @Override
    public boolean filter(String name) {

        return name.matches(TypeOfFilter.searchType);
    }
}
