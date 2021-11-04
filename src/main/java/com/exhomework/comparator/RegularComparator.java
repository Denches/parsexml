package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

public class RegularComparator extends AbstractComparator {

    @Override
    public boolean compare() {

        return name.matches(TypeOfFilter.searchType);
    }
}
