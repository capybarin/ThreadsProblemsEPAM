package com.company.misc.Task93;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.Random;

public class HashMapWorker implements Runnable {
    private LongAdder timer = new LongAdder();
    private HashMap<Integer, Integer> hashMap;
    Random random = new Random();

    public HashMapWorker(HashMap<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public synchronized void run() {
        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            hashMap.put(random.nextInt(),random.nextInt());
        }

        /*for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/

        long finish = System.nanoTime();

        timer.add(finish - start);
    }

    public LongAdder getTimer() {
        return timer;
    }
}
