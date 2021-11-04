package com.exhomework.builder;

public class FactoryBuilderComparator {

    public Search comparator (SearchType searchType){

        return switch (searchType) {
            case Full -> new Full();
            case Equals -> new Equal();
            case Mask -> new Mask();
            case Regular -> new Regular();
        };
    }
}