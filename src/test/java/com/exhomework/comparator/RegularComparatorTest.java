package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.*;

public class RegularComparatorTest {

    private static Comparator equal;
    private static ArgumentList argument;

    @BeforeAll
    static void init(){
        argument = new ArgumentList() {};
        argument.setMask("file-.*.j.*");

        equal = new RegularComparator(argument);
    }

    @DisplayName("Equals test")
    @Test
    void equals(){
        Assertions.assertTrue(equal.compare("file-1073842118.java"));
    }

    @DisplayName("Not equals test")
    @Test
    void notEquals(){
        Assertions.assertFalse(equal.compare("file-776194140.xml"));
    }

    @DisplayName("filename is null")
    @Test
    void filenameIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> equal.compare(null));
    }

    @AfterAll
    static void tearDown(){
        argument = null;
        equal = null;
    }
}
