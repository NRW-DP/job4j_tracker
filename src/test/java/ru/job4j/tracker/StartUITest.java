package ru.job4j.tracker;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"Item name"});
        Tracker tracker = new Tracker();
        StartUI.createItem(in, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Item name");
        assertThat(created.getName(), is(expected.getName()));
    }
}