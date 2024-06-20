package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("new item");
        boolean replaced = tracker.replace(item.getId(), newItem);
        assertThat(replaced).isTrue();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(newItem.getName());
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item foundItem = tracker.findById(item.getId());
        assertThat(foundItem).isEqualTo(item);
    }

    @Test
    public void whenInitTrackerWithConnection() {
        SqlTracker tracker = new SqlTracker(connection);
        assertThat(tracker).isNotNull();
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int itemId = item.getId();
        tracker.delete(itemId);
        Item foundItem = tracker.findById(itemId);
        assertNull(foundItem, "Item should be null after deletion");
    }

    @Test
    public void whenFindItemsByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        List<Item> expect = List.of(item);
        assertThat(tracker.findByName(item.getName())).isEqualTo(expect);
    }

    @Test
    public void whenReturnAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findAll();
        List<Item> expect = Arrays.asList(item, item2, item3);
        assertThat(result).isEqualTo(expect);
    }
}

