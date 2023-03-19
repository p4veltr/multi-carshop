package org.example;

public class Main {
    public static void main(String[] args) {
        CarShop carShop = new CarShop();

        carShop.startProducing();

        for (int i = 0; i < 10; i++) {
            carShop.startByer(new Byer("Покупатель №" + (i + 1)));
        }
    }
}
