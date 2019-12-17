package com.company;

import com.company.misc.CountToBomb;
import com.company.misc.IncAndOutput;

public class Main {
    private void tmp() {
        IncAndOutput incAndOutput = new IncAndOutput();
        int num = 1_000_000;

        new Thread(() -> {
            for (int j = 0; j < num; j++) {
                incAndOutput.Inc();
            }
        }).start();

        new Thread(() -> {
            for (int j = 0; j < num; j++) {
                incAndOutput.Output();
            }
        }).start();
    }

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

        
    }
}
