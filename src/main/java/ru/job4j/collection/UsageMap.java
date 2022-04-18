package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> name = new HashMap<>();
        name.put("abc@gmail.com", "Ivanov Ivan Ivanovich");
        name.put("qwerty@gmail.com", "Sidorov Oleg Ivanovich");
        name.put("qq@gmail.com", "Petrov Taras Ivanovich");
        for (String key : name.keySet()) {
            String value = name.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
