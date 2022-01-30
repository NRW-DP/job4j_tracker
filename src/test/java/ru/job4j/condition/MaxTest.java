package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxTest {

    @Test
    public void max() {
        Max check = new Max();
        int result = Math.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void testMax() {
    }

    @Test
    public void testMax1() {
    }
}
