package ru.job4j.pojo;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passenger(int count) {
        System.out.println("Количество пассажиров в поездке: " + count);
    }

     @Override
    public double refuel(double quantity, double price) {
        price *= quantity;
        return price;
    }
}
