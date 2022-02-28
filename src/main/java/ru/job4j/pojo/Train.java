package ru.job4j.pojo;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Длительность поездки - 6 часов");
    }

    @Override
    public void typeOfTransport() {
        System.out.println("Транспортное средство - поезд");
    }
}
