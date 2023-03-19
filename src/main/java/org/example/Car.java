package org.example;

public class Car {
    private final int productionNumber;

    public Car(int productionNumber) {
        this.productionNumber = productionNumber;
    }

    @Override
    public String toString() {
        return "Авто №" + productionNumber;
    }
}
