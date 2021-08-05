package com.utils;

import java.util.Random;

public class Utils {

    public int getRandomNumberUntil(int bound) {
        return new Random().nextInt(bound);
    }
}
