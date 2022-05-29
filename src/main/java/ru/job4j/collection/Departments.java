package ru.job4j.collection;

import java.util.*;

public class Departments {
        public static List<String> fillGaps(List<String> deps) {
            Set<String> temp = new LinkedHashSet<>();
            for (String value : deps) {
                StringBuilder start = new StringBuilder();
                for (String el : value.split("/")) {
                    temp.add(start + el);
                    start.append(el).append("/");
                }
            }
            return new ArrayList<>(temp);
        }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
