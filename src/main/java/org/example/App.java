package org.example;

import java.util.concurrent.atomic.LongAdder;

public class App {
    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();

        Shop shopOne = new Shop(longAdder);
        Shop shopTwo = new Shop(longAdder);
        Shop shopThree = new Shop(longAdder);

        Thread thread1 = new Thread(null, shopOne::calculate, "Shop 1");
        Thread thread2 = new Thread(null, shopTwo::calculate, "Shop 2");
        Thread thread3 = new Thread(null, shopThree::calculate, "Shop 3");
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Выручка по всем магазинам составила: " + longAdder.sum() + " у.е.");
    }
}