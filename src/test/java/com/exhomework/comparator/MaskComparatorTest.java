package com.exhomework.comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaskComparatorTest extends Initialization {

    @BeforeAll
   static void init(){
        argument.setMask("*.java");
        equal = new MaskComparator(argument);
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
}