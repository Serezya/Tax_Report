package org.example;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        Shop shop = new Shop();

        Thread thread1 = new Thread(null, shop::getSumMas, "Магазин 1");
        Thread thread2 = new Thread(null, shop::getSumMas, "Магазин 2");
        Thread thread3 = new Thread(null, shop::getSumMas, "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\nВыручка по всем магазинам составила: " + shop.money.get() + " у.е.");
    }
}
