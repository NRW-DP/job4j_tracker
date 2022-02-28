package ru.job4j.pojo;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Длительность поездки - 2 часа");
    }

    @Override
    public void typeOfTransport() {
        System.out.println("Транспортное средство - самолёт");
    }
}
