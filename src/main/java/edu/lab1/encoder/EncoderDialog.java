package edu.lab1.encoder;

import edu.lab1.models.Table;
import java.util.Scanner;
import static edu.lab1.utils.InputUtils.getScanner;
import static utils.PrintUtils.print;
import static utils.PrintUtils.println;
import static utils.RandomUtils.getRandomSuffix;
import static utils.UserInputUtils.getUserInput;
import static utils.UserInputUtils.getUserPositiveInt;

public final class EncoderDialog {
    private EncoderDialog() {
    }

    private static Table table;
    private static String plainText;
    private static String key;

    public static EncoderDialogResult startDialogAndGetResult() {
        println("==== ШИФРАТОР ====");
        print("");

        Scanner scanner = getScanner();
        createTable(scanner);
        createPlainText(scanner);
        createKey(scanner);

        return new EncoderDialogResult(table, plainText, key);
    }

    private static void createTable(Scanner scanner) {
        print("Введите ширину таблицы: ");
        int width = getUserPositiveInt(scanner);

        print("Введите высоту таблицы: ");
        int height = getUserPositiveInt(scanner);

        table = new Table(width, height);
    }

    private static void createPlainText(Scanner scanner) {
        println("");
        println("Вы можете зашифровать не более " + table.getSize() + " символов.");
        println("Не оставляйте в исходном тексте подсказки о его структуре (пробелы, знаки препинания и т. д.).");
        print("Введите исходный текст: ");
        plainText = getUserInput(scanner);
        adjustPlainText();
    }

    private static void createKey(Scanner scanner) {
        println("Для шифрования исходного текста требуется ключ.");
        print("Введите ключ из " + table.getWidth() + " символов: ");
        key = getUserInput(scanner);
        adjustKey();
    }

    private static void adjustPlainText() {
        if (plainText.length() > table.getSize()) {
            trimPlainText();
        } else if (plainText.length() < table.getSize()) {
            expandPlainText();
        }
    }

    private static void trimPlainText() {
        println("");
        println("Исходный текст содержит более " + table.getSize() + " символов.");
        println("С конца исходного текста были удалены лишние символы.");

        plainText = plainText.substring(0, table.getSize());

        println("Итоговый исходный текст: " + plainText);
        println("");
    }

    private static void expandPlainText() {
        println("");
        println("Исходный текст содержит менее " + table.getSize() + " символов.");
        println("В конец исходного текста были добавлены случайные символы.");

        int suffixLength = table.getSize() - plainText.length();
        plainText = plainText + getRandomSuffix(suffixLength);

        println("Итоговый исходный текст: " + plainText);
        println("");
    }

    private static void adjustKey() {
        if (key.length() > table.getWidth()) {
            trimKey();
        } else if (key.length() < table.getWidth()) {
            expandKey();
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
