package com.company.misc;

public class IncAndOutput extends Thread{
    private int i = 0;
    private volatile boolean isReady = true;

    public void run(){
        int num = 1_000_000;

        new Thread(() -> {
            for (int j = 0; j < num; j++) {
                Inc();
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < num; j++) {
                Output();
            }
        }).start();
    }

    public synchronized void Inc(){
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        isReady = !isReady;
        notify();
    }

    public synchronized void Output(){
        while (isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isReady = !isReady;
        System.out.println(i);
        notify();
    }
}
