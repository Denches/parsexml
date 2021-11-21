package com.exhomework.comparator;

import com.exhomework.domain.ArgumentStore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskComparator extends Comparator {

    private final Pattern pattern;

    public MaskComparator(ArgumentStore argument) {
        super(argument);

        String newMask = processingMask();
        pattern = Pattern.compile(newMask);
    }

    @Override
    public boolean compare(String filename) {

        Matcher matcher = pattern.matcher(filename);

        return matcher.matches();
    }

    private String processingMask(){

        StringBuilder newMask = new StringBuilder();
        char[] chars = argument.getMask().toCharArray();

        for (char ch : chars){
            switch (ch) {
                case '.' -> newMask.append("\\.");
                case '?' -> newMask.append(".");
                case '*' -> newMask.append(".*");
                default  -> newMask.append(ch);
            }
        }

        return newMask.toString();
    }
}