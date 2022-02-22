package ru.job4j.pojo;

public interface Transport {
     void drive();

    void passenger(int count);

    double refuel(double quantity, double price);
}
