package com.exhomework.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaskComparatorTest extends Initialization {

    @BeforeEach
    void init(){
        argument.setMask("*.java");
        comparator = new MaskComparator(argument);
    }

    @Test
    void maskCompare(){
        Assertions.assertAll(
                () -> assertFalse(comparator.compare("file-776194140.xml")),
                () -> assertTrue(comparator.compare("file-1073842118.java")),
                () -> assertTrue(comparator.compare("file-123.java")),
                () -> assertFalse(comparator.compare("file-1498940214.xhtml"))
        );
    }
}