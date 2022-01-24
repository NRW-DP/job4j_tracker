package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int k) {
        return k - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int j) {
        return j / x;
    }

    public int sumAllOperation(int p) {
        return sum(p) + multiply(p) + minus(p) + divide(p);
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(10));
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        Calculator result1 = new Calculator();
        int rsl1 = result1.divide(20);
        System.out.println(rsl1);
        Calculator sumAll = new Calculator();
        int rsl2 = sumAll.sumAllOperation(5);
        System.out.println(rsl2);
    }
}