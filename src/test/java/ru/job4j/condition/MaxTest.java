package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void when1And2Then2() {
        int expected = 2;
        int result = Max.max(1, 2);
        Assert.assertEquals(expected, result, 0.01);
    }

    @Test
    public void wen1and2and3Then3() {
        int expected = 3;
        int result2 = Max.max(1, 2, 3);
        Assert.assertEquals(expected, result2, 0.01);
    }

    @Test
    public void when1and2and3and4Then4() {
        int expected = 4;
        int result3 = Max.max(1, 2, 3, 4);
        Assert.assertEquals(expected, result3, 0.01);
    }
}
