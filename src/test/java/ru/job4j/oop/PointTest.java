package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to40then4() {
        int expected = 4;
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        Assert.assertEquals(expected, rsl, 0.01);
    }

    @Test
    public void when000to222then3() {
        int expected = 3;
        Point c = new Point(0, 0, 0);
        Point d = new Point(2, 2, 2);
        double rsl2 = c.distance3d(d);
        Assert.assertEquals(expected, rsl2, 0.50);
    }
}