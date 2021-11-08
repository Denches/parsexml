package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

public class EqualComparator extends AbstractComparator {
    @Override
    public boolean compare(String name) {

        return name.equals(TypeOfFilter.searchType);
    }
}
