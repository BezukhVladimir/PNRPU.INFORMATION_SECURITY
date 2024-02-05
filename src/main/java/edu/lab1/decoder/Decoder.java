package edu.lab1.decoder;

import edu.lab1.models.Table;
import java.util.List;
import static edu.lab1.utils.KeyUtils.getColOrder;

public final class Decoder {
    private Decoder() {
    }

    public static String decodeAndGetPlainText(
        Table table, String ciphertext, String key
    ) {
       return getPlainText(table, ciphertext, getColOrder(key));
    }


    public static String getPlainText(Table table, String ciphertext, List<Integer> colOrder) {
        char[] plainText = new char[ciphertext.length()];

        for (int i = 0; i < colOrder.size(); ++i) {
            for (int row = 0; row < table.getHeight(); ++row) {
                plainText[row * table.getWidth() + colOrder.get(i)] = ciphertext.charAt(i * table.getHeight() + row);
            }
        }

        return new String(plainText);
    }
}
