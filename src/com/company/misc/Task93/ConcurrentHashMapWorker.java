package com.company.misc.Task93;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMapWorker implements Runnable{
    private LongAdder timer = new LongAdder();
    ConcurrentHashMap<Integer, Integer> concurrentHashMap;
    Random random = new Random();

    public ConcurrentHashMapWorker(ConcurrentHashMap<Integer, Integer> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }

    public LongAdder getTimer() {
        return timer;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        for(int i = 0; i < 1000; i++) {
            concurrentHashMap.put(random.nextInt(1000), random.nextInt(1000));
        }

        /*for(Map.Entry<Integer, Integer> entry : concurrentHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/

        long finish = System.nanoTime();

        timer.add(finish - start);
    }
}
