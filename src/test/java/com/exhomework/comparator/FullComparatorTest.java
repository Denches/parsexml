package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullComparatorTest{

    @Test
    void fullCompare(){
        ArgumentStore argument = new ArgumentStore();
        argument.setMask(null);
        Comparator comparator = new FullComparator(argument);

        Assertions.assertAll(
                () -> assertTrue(comparator.compare("file-776194140.xml")),
                () -> assertTrue(comparator.compare("file-1073842118.java")),
                () -> assertTrue(comparator.compare("file-123.java")),
                () -> assertTrue(comparator.compare("file-1498940214.xhtml"))
        );
    }
}
