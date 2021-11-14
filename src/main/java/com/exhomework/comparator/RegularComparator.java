package com.exhomework.comparator;

import com.exhomework.domain.ArgumentList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularComparator extends Comparator {

    private final Pattern pattern;

    public RegularComparator(ArgumentList argument) {
        super(argument);

        pattern = Pattern.compile(argument.getMask());
    }

    @Override
    public boolean compare(String filename) {

        Matcher matcher = pattern.matcher(filename);

        return matcher.matches();
    }
}