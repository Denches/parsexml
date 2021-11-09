package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

public class EqualComparator extends AbstractComparator {
    @Override
    public boolean compare(String filename) {

        return filename.equals(TypeOfFilter.searchType);
    }
}
