package org.example;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    private final int[] mas = new int[10];
    private final LongAdder longAdder;

    public Shop(LongAdder longAdder) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) Math.round((Math.random() * 2000));
        }
        this.longAdder = longAdder;
    }
    public int getSumMas(){
        return Arrays.stream(mas).sum();
    }

    public void calculate() {
        System.out.println("Выручка от " + Thread.currentThread().getName() + " составила " + getSumMas() + " у.е.");
        longAdder.add(getSumMas());
    }
}