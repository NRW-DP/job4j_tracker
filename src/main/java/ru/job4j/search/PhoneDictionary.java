package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        /*
             ArrayList<Person> result = new ArrayList<>();
        for (Person element : persons) {
            if (element.getPhone().contains(key)
                    || element.getAddress().contains(key)
                    || element.getName().contains(key)
                    || element.getSurname().contains(key)) {
                result.add(element);
            }
        }
        return result;
         Ниже находится реализция метода с использованием  Предиката / лямбда / функции высшего порядка;
          */
        Predicate<Person> first = lmd -> lmd.getPhone().contains(key);
        Predicate<Person> second = lmd -> lmd.getAddress().contains(key);
        Predicate<Person> third = lmd -> lmd.getName().contains(key);
        Predicate<Person> fourth = lmd -> lmd.getSurname().contains(key);
            Predicate<Person> combine = first.or(second).or(third).or(fourth);
            ArrayList<Person> result = new ArrayList<>();
            for (Person person : persons) {
                if (combine.test(person)) {
                    result.add(person);
                }
            }
            return result;
    }
}

