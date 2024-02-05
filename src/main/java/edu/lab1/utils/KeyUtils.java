package edu.lab1.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class KeyUtils {
    private KeyUtils() {
    }

    public static List<Integer> getColOrder(String key) {
        Map<Character, Integer> counters = new HashMap<>();

        char[] chars = key.toCharArray();
        Arrays.sort(chars);
        String sortedKey = new String(chars);

        List<Integer> order = new ArrayList<>();

        // Подсчёт вхождений
        for (int i = 0; i < sortedKey.length(); ++i) {
            counters.put(
                sortedKey.charAt(i),
                counters.getOrDefault(sortedKey.charAt(i), 0) + 1
            );
        }

        // Узнаём порядок обхода столбцов
        /*
         * Ищем символы с конца
         * key:       ababa
         * sortedKey: aaabb
         *
         * count = 3
         * (a)baba <--
         * order: 1
         *
         * count = 2
         * ab(a)ba <--
         * order: 1, 3
         *
         * count = 1
         * abab(a)
         * order: 1, 3, 5
         *
         * count = 2
         * a(b)aba <--
         * order: 1, 3, 5, 2
         *
         * count = 1
         * aba(b)a <--
         * order: 1, 3, 5, 2, 4
         */
        for (int i = 0; i < sortedKey.length(); ++i) {
            char current = sortedKey.charAt(i);
            int count = counters.get(current);

            int index = key.length();
            for (int j = 0; j < count; ++j) {
                index = key.lastIndexOf(current, index - 1);
            }

            counters.put(
                current,
                counters.get(current) - 1
            );

            order.add(index);
        }

        return order;
    }
}
