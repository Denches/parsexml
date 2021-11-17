package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullComparatorTest{

    @Test
    void fullCompare(){
        ArgumentList argument = new ArgumentList();
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
