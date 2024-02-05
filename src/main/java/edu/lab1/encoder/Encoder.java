package edu.lab1.encoder;

import edu.lab1.models.Table;
import java.util.List;
import static edu.lab1.utils.KeyUtils.getColOrder;

public final class Encoder {
    private Encoder() {
    }

    public static String encodeAndGetCipherText(
        Table table, String plainText, String key
    ) {
        return getCiphertext(table, plainText, getColOrder(key));
    }

    public static String getCiphertext(Table table, String plainText, List<Integer> colOrder) {
        StringBuilder sb = new StringBuilder();

        for (int index : colOrder) {
            sb.append(getCol(table, plainText, index));
        }

        return sb.toString();
    }

    private static String getCol(Table table, String plainText, int index) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < table.getHeight(); ++row) {
            sb.append(plainText.charAt(row * table.getWidth() + index));
        }

        return sb.toString();
    }
}
