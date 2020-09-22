package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;


public class App
{
    public static void main( String[] args ) throws Exception {
        int countShops = 3;
        final ExecutorService executorService = Executors.newFixedThreadPool(countShops);
        List<Callable <Integer>> myCallable = new ArrayList<>(){{
            add(new Shop());
            add(new Shop());
            add(new Shop());
        }};

        LongAdder longAdder = new LongAdder();
        for (Callable<Integer> integerCallable : myCallable) {
            longAdder.add(integerCallable.call());
        }

        System.out.println("Выручка " + myCallable.size() + " магазинов за день составила: " + longAdder.sum());
        executorService.shutdown();
    }
}
