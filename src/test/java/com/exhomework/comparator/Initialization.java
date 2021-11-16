package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;
import org.junit.jupiter.api.AfterEach;

public class Initialization {

    protected Comparator comparator;
    protected ArgumentList argument = new ArgumentList() {};

    @AfterEach
    void tearDown(){
        argument = null;
        comparator = null;
    }
}
