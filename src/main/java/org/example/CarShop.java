package org.example;

import java.util.ArrayList;

public class CarShop {
    public static final int CAR_PRODUCING_TIME_MILLIS = 3000;
    public static final int TOTAL_CARS_TO_PRODUCE = 10;
    private final ArrayList<Car> cars = new ArrayList<>();
    public void startProducing() {
        new Thread(() -> {
            for (int i = 0; i < TOTAL_CARS_TO_PRODUCE; i++) {
                try {
                    Thread.sleep(CAR_PRODUCING_TIME_MILLIS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Car car = new Car(i + 1);
                synchronized (this) {
                    cars.add(car);
                    this.notify();
                    System.out.println("+ Производитель выпустил новое авто: " + car);
                }
            }
        }).start();

    }
    public void startByer (Byer byer) {
        new Thread(() -> {
            System.out.println("* " + byer + " желает купить авто!");
            while (true) {
                if (byer.getByingCheckDelayMillis() != 0) {
                    try {
                        Thread.sleep(byer.getByingCheckDelayMillis());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                synchronized (this) {
                    if (cars.size() > 0) {
                        Car car = cars.get(0);
                        cars.remove(0);
                        System.out.println("- " + byer + " приобрёл авто: " + car);
                        break;
                    } else {
                        System.out.println("! " + byer + ": машин нет");
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }
}
