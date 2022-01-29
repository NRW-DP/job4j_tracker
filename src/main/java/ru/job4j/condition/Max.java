package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return Math.max(left, right);
    }

    public static int max(int left, int right, int top) {
        return Math.max(max(left, right), top);
    }

    public static int max(int left, int right, int top, int bottom) {
        return Math.max(max(left, right, top), bottom);
    }
}
