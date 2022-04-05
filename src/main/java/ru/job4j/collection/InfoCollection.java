package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class InfoCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");
        for (String str : collection) {
            System.out.println(str);
        }

        Collection<String> list = new ArrayList<>();
        list.addAll(collection);
        for (String str : list) {
            System.out.println(str);
        }
        collection.remove("two");
        System.out.println("Вывод содержимого коллекции после удаления");
        for (String str : collection) {
            System.out.println(str);
        }
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("one");
        collection1.add("two");
        collection1.add("three");
        System.out.println("Размер коллекции равен: " + collection1.size());
        System.out.println("Коллекция содержит элемент two: " + collection1.contains("two"));
        System.out.println("Содержимое в виде массива: " + Arrays.toString(collection1.toArray()));
        collection.clear();
        System.out.println("Коллекция после очистки пуста: " + collection1.isEmpty());
    }
}
