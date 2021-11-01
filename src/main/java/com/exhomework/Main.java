package com.exhomework;

import com.exhomework.Parser.ArgumentParser;
import com.exhomework.builder.Factory;
import com.exhomework.builder.Search;
import com.exhomework.exception.ArgumentException;

public class Main {

    public static void main(String[] args) throws ArgumentException {

        ArgumentParser argumentProcess = new ArgumentParser(args);

        Factory factory = new Factory();
        Search search = factory.filter(TypeOfFilter.argForPrint());
        search.print();

    }
}
