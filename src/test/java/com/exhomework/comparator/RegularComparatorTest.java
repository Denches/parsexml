package com.exhomework.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularComparatorTest extends Initialization{

    @BeforeEach
    void init(){
        argument.setMask(".*?[a-z]{4}-\\d+\\.[a-z]+");
        comparator = new RegularComparator(argument);
    }

    @Test
    void regularCompare(){
        Assertions.assertAll(
                () -> assertTrue(comparator.compare("file-776194140.xml")),
                () -> assertTrue(comparator.compare("file-1073842118.java")),
                () -> assertTrue(comparator.compare("file-123.java")),
                () -> assertTrue(comparator.compare("file-1498940214.xhtml"))
        );
    }
}
