package utils;

import java.util.Random;

public final class RandomUtils {
    private RandomUtils() {
    }

    private static final Random RANDOM = new Random();

    public static String getRandomSuffix(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            sb.append(getRandomChar());
        }

        return sb.toString();
    }

    public static char getRandomChar() {
        String allCharacters =
            "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
                + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
                + "0123456789";

        return allCharacters.charAt(RANDOM.nextInt(allCharacters.length()));
    }
}
