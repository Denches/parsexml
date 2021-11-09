package com.exhomework.comparator;

import com.exhomework.TypeOfFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskComparator extends AbstractComparator {

    private Pattern pattern;

    @Override
    public boolean compare(String filename) {
        pattern = Pattern.compile(processingMask());

        Matcher matcher = pattern.matcher(filename);
        return matcher.matches();
    }

    private String processingMask(){

        StringBuilder newMask = new StringBuilder();
        char[] chars = TypeOfFilter.searchType.toCharArray();

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
