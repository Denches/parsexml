package com.exhomework.comparator;

public class FactoryComparator {

    public AbstractComparator comparator (SearchType searchType){

        return switch (searchType) {
            case Full -> new FullComparator();
            case Equals -> new EqualComparator();
            case Mask -> new MaskComparator();
            case Regular -> new RegularComparator();
        };
    }
}
