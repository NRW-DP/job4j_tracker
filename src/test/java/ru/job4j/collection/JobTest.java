package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {
    @Test
    public void whenCompareAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Fix bugs", 2),
                new Job("Impl task", 3));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Fix bugs", 2),
                new Job("Impl task", 3));
        assertThat(rsl, greaterThan(0));
    }
}