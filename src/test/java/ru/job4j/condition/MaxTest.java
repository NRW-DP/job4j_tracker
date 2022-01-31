package ru.job4j.condition;

import org.junit.Test;

public class MaxTest {

    @Test
    public void when1And2Then2() {
        int result = Max.max(1, 2);
        System.out.println(result);
    }

    @Test
    public void wen1and2and3Then3() {
        int result2 = Max.max(1, 2, 3);
        System.out.println(result2);
    }

    @Test
    public void when1and2and3and4Then4() {
        int result3 = Max.max(1, 2, 3, 4);
        System.out.println(result3);
    }
}
