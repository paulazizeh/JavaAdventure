package edu.cscc.javaadventure;

import java.util.Random;

public interface Roller {
    static int roll(int bound) {
        Random random = new Random();
        int value = random.nextInt(bound);
        if (value == 0) {
            return 1;
        }

        return value;
    }
}
