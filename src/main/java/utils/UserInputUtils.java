package utils;

import java.util.Scanner;
import static utils.PrintUtils.print;

public final class UserInputUtils {
    private UserInputUtils() {
    }

    public static int getUserPositiveInt(Scanner scanner) {
        while (true) {
            int positiveInteger = getUserInt(scanner);

            if (positiveInteger > 0) {
                return positiveInteger;
            } else {
                print("Некорректный ввод. Введите целое число больше нуля: ");
            }
        }
    }

    public static int getUserInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                print("Некорректный ввод. Введите целое число: ");
            }
        }
    }

    public static String getUserInput(Scanner scanner) {
        return scanner.nextLine();
    }
}
