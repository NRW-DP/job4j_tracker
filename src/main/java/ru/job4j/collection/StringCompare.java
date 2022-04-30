package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < right.length(); j++) {
                rsl = Character.compare(left.charAt(i), right.charAt(j));
                if (rsl != 0) {
                    break;
                }
            }
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
