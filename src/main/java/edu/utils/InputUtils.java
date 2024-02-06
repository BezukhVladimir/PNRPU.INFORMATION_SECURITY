package edu.utils;

import java.util.Scanner;

public final class InputUtils {
    private InputUtils() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner() {
        return SCANNER;
    }
}
