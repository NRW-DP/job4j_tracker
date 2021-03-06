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
        Predicate<Person> first = p -> p.getPhone().contains(key);
        Predicate<Person> second = p -> p.getAddress().contains(key);
        Predicate<Person> third = p -> p.getName().contains(key);
        Predicate<Person> fourth = p -> p.getSurname().contains(key);
            var combine = first.or(second).or(third).or(fourth);
            var result = new ArrayList<Person>();
            for (var person : persons) {
                if (combine.test(person)) {
                    result.add(person);
                }
            }
            return result;
    }
}

