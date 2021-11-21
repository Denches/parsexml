package com.exhomework.comparator;

import com.exhomework.constant.XConstant.SearchType;
import com.exhomework.domain.ArgumentStore;

public class FactoryMethod {

    public Comparator comparator(SearchType searchType, ArgumentStore argument){

        return switch (searchType) {
            case Full    -> new FullComparator(argument);
            case Equals  -> new EqualComparator(argument);
            case Mask    -> new MaskComparator(argument);
            case Regular -> new RegularComparator(argument);
        };
    }
}