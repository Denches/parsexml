package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaskComparatorTest {

    @Test
    void maskCompare(){
        ArgumentList argument = new ArgumentList();
        argument.setMask("*.java");
        Comparator comparator = new MaskComparator(argument);

        Assertions.assertAll(
                () -> assertFalse(comparator.compare("file-776194140.xml")),
                () -> assertTrue(comparator.compare("file-1073842118.java")),
                () -> assertTrue(comparator.compare("file-123.java")),
                () -> assertFalse(comparator.compare("file-1498940214.xhtml"))
        );
    }
}