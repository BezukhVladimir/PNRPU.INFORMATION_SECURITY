package edu.utils;

import java.util.Scanner;

public final class UserInputUtils {
    private UserInputUtils() {
    }

    public static int getUserPositiveInt(Scanner scanner) {
        while (true) {
            int positiveInteger = getUserInt(scanner);

            if (positiveInteger > 0) {
                return positiveInteger;
            } else {
                PrintUtils.print("Некорректный ввод. Введите целое число больше нуля: ");
            }
        }
    }

    public static int getUserInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                PrintUtils.print("Некорректный ввод. Введите целое число: ");
            }
        }
    }

    public static String getUserInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
