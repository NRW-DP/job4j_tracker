package ru.job4j.pojo;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Длительность поездки - 12 часов");
    }

    @Override
    public void typeOfTransport() {
        System.out.println("Транспортное средство - автобус");
    }
}
