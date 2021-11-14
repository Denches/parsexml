package com.exhomework.comparator;

import com.exhomework.constant.XConstant.SearchType;
import com.exhomework.domain.ArgumentList;

public class FactoryMethod {

    public Comparator comparator(SearchType searchType, ArgumentList argument){

        return switch (searchType) {
            case Full    -> new FullComparator(argument);
            case Equals  -> new EqualComparator(argument);
            case Mask    -> new MaskComparator(argument);
            case Regular -> new RegularComparator(argument);
        };
    }
}