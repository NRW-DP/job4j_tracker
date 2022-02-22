package ru.job4j.pojo;

public class Bus implements Transport {
    @Override
    public void drive() {
    }

    @Override
    public void passenger(int count) {
    }

     @Override
    public double refuel(double quantity, double price) {
        return price;
    }
}
