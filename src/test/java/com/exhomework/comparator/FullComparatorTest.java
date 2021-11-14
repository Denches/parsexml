package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.*;

public class FullComparatorTest {

    private static Comparator equal;
    private static ArgumentList argument;

    @BeforeAll
    static void init(){
        argument = new ArgumentList() {};
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

    @AfterAll
    static void tearDown(){
        argument = null;
        equal = null;
    }
}
