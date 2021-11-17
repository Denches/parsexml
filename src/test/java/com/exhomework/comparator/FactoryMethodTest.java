package com.exhomework.comparator;

import com.exhomework.constant.XConstant;
import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTest {

    @DisplayName("Create classes with correct type")
    @Test
    void createClassesWithCorrectType(){
        ArgumentList argument = new ArgumentList();
        argument.setMask("");
        FactoryMethod factory = new FactoryMethod();

        Assertions.assertAll(
                () -> assertEquals(EqualComparator.class, factory.comparator(XConstant.SearchType.Equals,argument).getClass()),
                () -> assertEquals(FullComparator.class, factory.comparator(XConstant.SearchType.Full,argument).getClass()),
                () -> assertEquals(MaskComparator.class, factory.comparator(XConstant.SearchType.Mask,argument).getClass()),
                () -> assertEquals(RegularComparator.class, factory.comparator(XConstant.SearchType.Regular,argument).getClass())
        );
    }
}
