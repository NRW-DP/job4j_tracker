package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

//    public Item[] findAll() {
//       return
//    }

    public Item[] findByName(String key) {
            Item[] found = new Item[items.length];
            int count = 0;
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].getName().equals(key)) {
                found[0] = items[i];
                count++;
            }
        }
        return found;
    }
        }