package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    private final static String ADD_ITEM = "INSERT INTO items (name, created) VALUES (?, ?)";
    private final static String REPLACE_ITEM = "UPDATE items SET name = ?, created = ? WHERE id = ?";
    private final static String DELETE_ITEM = "DELETE FROM items WHERE id = ?";
    private final static String FIND_ALL_ITEMS = "SELECT * FROM items";
    private final static String FIND_ITEM_BY_NAME = "SELECT * FROM items WHERE name = ?";
    private final static String FIND_BY_ID = "SELECT * FROM items WHERE id = ?";

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    public SqlTracker() {
        init();
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database connection", e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement(ADD_ITEM, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                } else {
                    throw new IllegalStateException("Failed to retrieve generated ID");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to add item", e);
        }
        return item;
    }

    private Item createItem(ResultSet set) throws SQLException {
        return new Item(
                set.getInt("id"),
                set.getString("name"),
                set.getTimestamp("created").toLocalDateTime()
        );
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement statement = connection.prepareStatement(REPLACE_ITEM)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            int updateCount = statement.executeUpdate();
            return updateCount > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to replace item with id " + id, e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ITEM)) {
            statement.setInt(1, id);
            int updateCount = statement.executeUpdate();
            if (updateCount == 0) {
                System.out.println("The element with id " + id + " was not found and deleted");
            } else {
                System.out.println("The element with id " + id + " has been successfully deleted");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete item with id " + id, e);
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_ITEMS)) {
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    itemList.add(createItem(set));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all items", e);
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(FIND_ITEM_BY_NAME)) {
            statement.setString(1, key);
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    itemList.add(createItem(set));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find items by name", e);
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet set = statement.executeQuery()) {
                if (set.next()) {
                    return createItem(set);
                } else {
                    throw new IllegalArgumentException("Item with id " + id + " not found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find item by id", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
