package com.company.misc;

public class CountToBomb extends Thread {
    public void run(){
        for (int i = 10; i > 0; --i){
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bomb");
    }
}
