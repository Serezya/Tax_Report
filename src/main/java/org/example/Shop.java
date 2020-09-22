package org.example;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Shop implements Callable<Integer> {
    private final int[] mas = new int[10];

    public Shop() {
        for(int i = 0; i < mas.length; i++){
            mas[i] = 1000 + (int) Math.round((Math.random() * 2000));
        }
    }

    @Override
    public Integer call() {
        return Arrays.stream(mas).sum();
    }
}
