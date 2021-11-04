package com.exhomework.builder;

import com.exhomework.TypeOfFilter;

public class Regular extends Search {

    @Override
    public boolean comparator() {

        return name.matches(TypeOfFilter.searchType);
    }
}
