package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.AfterAll;

public class Initialization {

    protected static Comparator equal;
    protected static ArgumentList argument = new ArgumentList() {};


    @AfterAll
    static void tearDown(){
        argument = null;
        equal = null;
    }
}
