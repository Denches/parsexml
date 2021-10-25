package com.exhomework;

import java.util.List;

public final class Filter {

    private static String filter = null;

    public static void setFilter(String filter) {
        Filter.filter = filter;
    }

    public static void search(List<String> list){

        /**
         *  Разный код символов
         */

        if (filter != null) {

            filter = filter.replace("‘",""); //код символа: 8216
            filter = filter.replace("’",""); //код символа: 8217

            if (filter.charAt(0) == '*'){
                filter = "." + filter;
            }
        }

        for (String path : list) {

            if (filter == null || path.equals(filter) || path.endsWith(filter) || path.matches(filter.replaceAll("'",""))){

                System.out.println(path);
            }
        }
    }
}
