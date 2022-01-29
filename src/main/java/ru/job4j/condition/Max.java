package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int right, int top) {
        return max(max(int left, int right)) > top ? max(max(int left, int right)) : top;
    }

    public static int max(int left, int right, int top, int bottom) {
        return ;
    }
}
