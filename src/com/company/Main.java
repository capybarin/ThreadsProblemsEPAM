package com.company;

public class Main {

    public void Task_9_1(){
        new Thread(() -> {
            for (int i = 10; i >= 1; i--) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                    if(i-1==0) {
                        Thread.sleep(1000);
                        System.out.println("Bomb");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.Task_9_1();
    }
}
