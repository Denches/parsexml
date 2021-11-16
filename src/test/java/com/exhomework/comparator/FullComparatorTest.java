package com.exhomework.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullComparatorTest extends Initialization{

    @BeforeEach
    void init(){
        argument.setMask(null);
        comparator = new FullComparator(argument);
    }

    @Test
    void fullCompare(){
        Assertions.assertAll(
                () -> assertTrue(comparator.compare("file-776194140.xml")),
                () -> assertTrue(comparator.compare("file-1073842118.java")),
                () -> assertTrue(comparator.compare("file-123.java")),
                () -> assertTrue(comparator.compare("file-1498940214.xhtml"))
        );
    }
}
