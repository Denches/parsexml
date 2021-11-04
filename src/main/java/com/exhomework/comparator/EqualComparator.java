package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

public class EqualComparator extends AbstractComparator {
    @Override
    public boolean compare() {

        return  name.contains(TypeOfFilter.searchType);
    }
}
