package edu.lab1.encoder;

import edu.lab1.models.Table;
import java.util.Scanner;
import static edu.utils.InputUtils.getScanner;
import static edu.utils.PrintUtils.print;
import static edu.utils.PrintUtils.println;
import static edu.utils.RandomUtils.getRandomSuffix;
import static edu.utils.UserInputUtils.getUserInput;
import static edu.utils.UserInputUtils.getUserPositiveInt;

public final class EncoderDialog {
    private EncoderDialog() {
    }

    private static Table table;
    private static String plaintext;
    private static String key;

    public static EncoderDialogResult startDialogAndGetResult() {
        println("==== ШИФРАТОР ====");
        print("");

        Scanner scanner = getScanner();
        createTable(scanner);
        createPlaintext(scanner);
        createKey(scanner);

        return new EncoderDialogResult(table, plaintext, key);
    }

    private static void createTable(Scanner scanner) {
        print("Введите ширину таблицы: ");
        int width = getUserPositiveInt(scanner);

        print("Введите высоту таблицы: ");
        int height = getUserPositiveInt(scanner);

        table = new Table(width, height);
    }

    private static void createPlaintext(Scanner scanner) {
        println("");
        println("Вы можете зашифровать не более " + table.getSize() + " символов.");
        println("Не оставляйте в исходном тексте подсказки о его структуре (пробелы, знаки препинания и т. д.).");
        print("Введите исходный текст: ");
        plaintext = getUserInput(scanner);
        adjustPlaintext();
    }

    private static void createKey(Scanner scanner) {
        println("Для шифрования исходного текста требуется ключ.");
        print("Введите ключ из " + table.getWidth() + " символов: ");
        key = getUserInput(scanner);
        adjustKey();
    }

    private static void adjustPlaintext() {
        if (plaintext.length() > table.getSize()) {
            trimPlaintext();
        } else if (plaintext.length() < table.getSize()) {
            expandPlaintext();
        } else {
            println("");
        }
    }

    private static void trimPlaintext() {
        println("");
        println("Исходный текст содержит более " + table.getSize() + " символов.");
        println("С конца исходного текста были удалены лишние символы.");

        plaintext = plaintext.substring(0, table.getSize());

        println("Итоговый исходный текст: " + plaintext);
        println("");
    }

    private static void expandPlaintext() {
        println("");
        println("Исходный текст содержит менее " + table.getSize() + " символов.");
        println("В конец исходного текста были добавлены случайные символы.");

        int suffixLength = table.getSize() - plaintext.length();
        plaintext = plaintext + getRandomSuffix(suffixLength);

        println("Итоговый исходный текст: " + plaintext);
        println("");
    }

    private static void adjustKey() {
        if (key.length() > table.getWidth()) {
            trimKey();
        } else if (key.length() < table.getWidth()) {
            expandKey();
        } else {
            println("");
        }
    }

    private static void trimKey() {
        println("");
        println("Ключ содержит более " + table.getWidth() + " символов.");
        println("С конца ключа были удалены лишние символы.");

        key = key.substring(0, table.getWidth());

        println("Итоговый ключ: " + key);
        println("");
    }

    private static void expandKey() {
        println("");
        println("Ключ содержит менее " + table.getWidth() + " символов.");
        println("В конец ключа были добавлены случайные символы.");

        int suffixLength = table.getWidth() - key.length();
        key = key + getRandomSuffix(suffixLength);

        println("Итоговый ключ: " + key);
        println("");
    }
}
