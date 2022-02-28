package ru.job4j.pojo;

public class Casting {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Autobus();

        Vehicle[] info = new Vehicle[]{plane, train, bus};
        for (Vehicle a : info) {
            a.move();
            a.typeOfTransport();
        }
    }
}
