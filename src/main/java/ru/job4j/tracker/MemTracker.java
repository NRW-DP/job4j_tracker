package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            item.setId(id);
            items.set(index, item);
        }
        return rls;
    }

    public void delete(int id) {
        try {
            int index = indexOf(id);
            if (index != -1) {
                items.remove(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error when deleting an item: " + e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
    }
}