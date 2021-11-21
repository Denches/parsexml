package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EqualComparatorTest {

    @Test
    void equalCompare(){
        ArgumentStore argument = new ArgumentStore();
        argument.setMask("file-776194140.xml");
        Comparator comparator = new EqualComparator(argument);

        Assertions.assertAll(
                () -> assertTrue(comparator.compare("file-776194140.xml")),
                () -> assertFalse(comparator.compare("file-1073842118.java")),
                () -> assertFalse(comparator.compare("file-123.java")),
                () -> assertFalse(comparator.compare("file-1498940214.xhtml"))
        );
    }
}
