package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
 /**  Дублирования методов для реализации сортировки list
    public static List<Folder> filterSize(List<Folder> list) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (f.getSize() > 100) {
                rsl.add(f);
            }
        }
        return rsl;
    }

    public static List<Folder> filterName(List<Folder> list) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (f.getName().contains("bug")) {
                rsl.add(f);
            }
        }
        return rsl;
    }

   Метод filter позволяет избавится от дублирования кода за счет применения  function.Predicate;
 */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder i : list) {
            if (pred.test(i)) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
