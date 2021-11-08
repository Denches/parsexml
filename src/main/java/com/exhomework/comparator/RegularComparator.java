package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

public class RegularComparator extends AbstractComparator {

    @Override
    public boolean compare(String name) {

        return name.matches(TypeOfFilter.searchType);
    }
}
