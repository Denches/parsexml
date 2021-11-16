package com.exhomework.comparator;

import com.exhomework.constant.XConstant;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTest extends Initialization {

    private static FactoryMethod factory;

    @BeforeEach
    void init(){
        factory = new FactoryMethod();
        argument.setMask("");
    }

    @DisplayName("Create classes with correct type")
    @Test
    void createClassesWithCorrectType(){
        Assertions.assertAll(
                () -> assertEquals(EqualComparator.class, factory.comparator(XConstant.SearchType.Equals,argument).getClass()),
                () -> assertEquals(FullComparator.class, factory.comparator(XConstant.SearchType.Full,argument).getClass()),
                () -> assertEquals(MaskComparator.class, factory.comparator(XConstant.SearchType.Mask,argument).getClass()),
                () -> assertEquals(RegularComparator.class, factory.comparator(XConstant.SearchType.Regular,argument).getClass())
        );
    }

    @AfterEach
    void tearDown(){
        factory = null;
        argument  = null;
    }
}
