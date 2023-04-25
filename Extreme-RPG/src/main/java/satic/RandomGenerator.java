package satic;

import java.util.Random;
public class RandomGenerator {
    private static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static double getRandomDouble() {
        return getRandomDouble(0.0, 1.0);
    }

    public static double getRandomDouble(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }
}
