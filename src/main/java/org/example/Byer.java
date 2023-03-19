package org.example;

import java.util.Random;

public class Byer {
    private final String name;
    private final int byingCheckDelayMillis;

    public Byer(String name) {
        this.name = name;
        this.byingCheckDelayMillis = new Random().nextInt(5) * 100;
    }
    @Override
    public String toString() {
        return name + " (" + byingCheckDelayMillis + ")";
    }

    public int getByingCheckDelayMillis() {
        return byingCheckDelayMillis;
    }
}
