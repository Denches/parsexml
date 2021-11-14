package com.exhomework.comparator;

import com.exhomework.constant.XConstant;
import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTest {

    private static FactoryMethod factory;
    private static ArgumentList argument;

    @BeforeAll
    static void init(){
        factory = new FactoryMethod();
        argument = new ArgumentList() {};
        argument.setMask("\\w");
    }

    @Test
    void createClassesWithCorrectType(){
        FactoryMethod factory = new FactoryMethod();

        Assertions.assertAll(
                () -> assertEquals(EqualComparator.class, factory.comparator(XConstant.SearchType.Equals,argument).getClass()),
                () -> assertEquals(FullComparator.class, factory.comparator(XConstant.SearchType.Full,argument).getClass()),
                () -> assertEquals(MaskComparator.class, factory.comparator(XConstant.SearchType.Mask,argument).getClass()),
                () -> assertEquals(RegularComparator.class, factory.comparator(XConstant.SearchType.Regular,argument).getClass())
        );
    }

    @AfterAll
    static void tearDown(){
        argument = null;
        factory = null;
    }
}
