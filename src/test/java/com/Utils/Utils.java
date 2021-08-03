package com.Utils;

import java.util.Random;

public class Utils {

        public int getRandomNumberUntil(int bound) {
            return new Random().nextInt(bound);
    }
}
