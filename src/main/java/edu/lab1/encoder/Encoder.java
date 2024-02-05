package edu.lab1.encoder;

import edu.lab1.models.Table;
import java.util.List;
import static edu.lab1.utils.KeyUtils.getColOrder;

public final class Encoder {
    private Encoder() {
    }

    public static String encodeAndGetCiphertext(
        Table table, String plaintext, String key
    ) {
        return getCiphertext(table, plaintext, getColOrder(key));
    }

    public static String getCiphertext(Table table, String plaintext, List<Integer> colOrder) {
        StringBuilder sb = new StringBuilder();

        for (int index : colOrder) {
            sb.append(getCol(table, plaintext, index));
        }

        return sb.toString();
    }

    private static String getCol(Table table, String plaintext, int index) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < table.getHeight(); ++row) {
            sb.append(plaintext.charAt(row * table.getWidth() + index));
        }

        return sb.toString();
    }
}
