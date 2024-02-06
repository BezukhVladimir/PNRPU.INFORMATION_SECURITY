package edu.lab1.decoder;

import edu.lab1.models.Table;
import java.util.Scanner;
import static edu.utils.InputUtils.getScanner;
import static edu.utils.PrintUtils.print;
import static edu.utils.PrintUtils.println;
import static edu.utils.UserInputUtils.getUserInput;
import static edu.utils.UserInputUtils.getUserPositiveInt;

public final class DecoderDialog {
    private DecoderDialog() {
    }

    private static Table table;
    private static String ciphertext;
    private static String key;

    public static DecoderDialogResult startDialogAndGetResult() {
        println("==== ДЕШИФРАТОР ====");
        print("");

        Scanner scanner = getScanner();
        createTable(scanner);
        createCiphertext(scanner);
        createKey(scanner);

        return new DecoderDialogResult(table, ciphertext, key);
    }

    private static void createTable(Scanner scanner) {
        print("Введите ширину таблицы: ");
        int width = getUserPositiveInt(scanner);

        print("Введите высоту таблицы: ");
        int height = getUserPositiveInt(scanner);

        table = new Table(width, height);
    }

    private static void createCiphertext(Scanner scanner) {
        println("");
        print("Введите шифротекст из " + table.getSize() + " символов: ");

        while (true) {
            ciphertext = getUserInput(scanner);

            if (ciphertext.length() != table.getSize()) {
                println("");
                println("Шифротекст должен содержать " + table.getSize() + " символов. ");
                print("Введите шифротекст: ");
            } else {
                println("");
                break;
            }
        }
    }

    private static void createKey(Scanner scanner) {
        println("Для дешифрования шифротекста требуется ключ.");
        print("Введите ключ из " + table.getWidth() + " символов: ");

        while (true) {
            key = getUserInput(scanner);

            if (key.length() != table.getWidth()) {
                println("");
                println("Ключ должен содержать " + table.getWidth() + " символов. ");
                print("Введите ключ: ");
            } else {
                println("");
                break;
            }
        }
    }
}
