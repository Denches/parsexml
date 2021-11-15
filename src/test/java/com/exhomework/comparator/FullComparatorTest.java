package com.exhomework.comparator;

import org.junit.jupiter.api.*;

public class FullComparatorTest extends Initialization{

    @BeforeAll
    static void init(){
        argument.setMask(null);
        equal = new FullComparator(argument);
    }

    @DisplayName("Equals test")
    @Test
    void equals(){
        Assertions.assertTrue(equal.compare("file-1073842118.java"));
    }

    @DisplayName("Not equals test")
    @Test
    @Disabled("Not realised in the FullComparator.class")
    void notEquals(){
        Assertions.assertFalse(equal.compare("file-776194140.xml"));
    }
}
