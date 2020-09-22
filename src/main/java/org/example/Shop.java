package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Shop {
    private final int[] mas = new int[10];
    AtomicInteger money = new AtomicInteger(0);

    public Shop() {
        for(int i = 0; i < mas.length; i++){
            mas[i] = (int) Math.round((Math.random() * 2000));
        }
    }

    public int getSumMas() {
        for (Integer i : mas) {
            money.addAndGet(i);
        }
        return money.get();
    }
}
