package com.company.misc.Task94;

import java.util.Random;
import java.util.concurrent.RecursiveTask;

public class RecursiveArray extends RecursiveTask<Integer> {
    private int[] array;
    private int from;
    private int to;

    public RecursiveArray(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    public static int[] init(int capacity) {
        Random random = new Random();
        int[] result = new int[capacity];
        for(int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(100);
        }
        return result;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    protected Integer compute() {
        if(to - from < 20) {
            int count = 0;

            for(int i = from; i < to; i++) {
                count += array[i];
            }

            return count;
        }
        else {
            int middle = (from + to) / 2;
            RecursiveArray first = new RecursiveArray(array, from, middle);
            RecursiveArray second = new RecursiveArray(array, middle, to);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }


}
