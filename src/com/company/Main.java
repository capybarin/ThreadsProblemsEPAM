package com.company;

import com.company.misc.Task91.CountToBomb;
import com.company.misc.Task92.IncAndOutput;
import com.company.misc.Task93.ConcurrentHashMapWorker;
import com.company.misc.Task93.HashMapWorker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        /**
         * Task 9.1
         */
        CountToBomb countToBomb = new CountToBomb();
        //countToBomb.run();

        /**
         * Task 9.2
         */
        IncAndOutput incAndOutput = new IncAndOutput();
        //incAndOutput.run();

        /**Task 9.3
         *
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        HashMapWorker hashMapWorker = new HashMapWorker(hashMap);
        ConcurrentHashMapWorker concurrentHashMapWorker = new ConcurrentHashMapWorker(concurrentHashMap);

        Thread threadHash = new Thread(hashMapWorker);
        Thread threadConcHash = new Thread(concurrentHashMapWorker);

        threadHash.start();
        threadConcHash.start();

        System.out.println("hash timer: " + hashMapWorker.getTimer() + "ns");
        System.out.println("concHash timer: " + concurrentHashMapWorker.getTimer() + "ns");

        
    }
}
