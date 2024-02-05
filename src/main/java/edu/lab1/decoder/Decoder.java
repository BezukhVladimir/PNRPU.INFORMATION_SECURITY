package edu.lab1.decoder;

import edu.lab1.models.Table;
import java.util.List;
import static edu.lab1.utils.KeyUtils.getColOrder;

public final class Decoder {
    private Decoder() {
    }

    public static String decodeAndGetPlaintext(
        Table table, String ciphertext, String key
    ) {
       return getPlaintext(table, ciphertext, getColOrder(key));
    }


    public static String getPlaintext(Table table, String ciphertext, List<Integer> colOrder) {
        char[] plaintext = new char[ciphertext.length()];

        for (int i = 0; i < colOrder.size(); ++i) {
            for (int row = 0; row < table.getHeight(); ++row) {
                plaintext[row * table.getWidth() + colOrder.get(i)] = ciphertext.charAt(i * table.getHeight() + row);
            }
        }

        return new String(plaintext);
    }
}
