package edu.lab1;

import edu.lab1.decoder.DecoderDialog;
import edu.lab1.encoder.EncoderDialog;
import static edu.lab1.decoder.Decoder.decodeAndGetPlainText;
import static edu.lab1.encoder.Encoder.encodeAndGetCipherText;
import static utils.PrintUtils.println;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        encoder();
        decoder();
    }

    private static void encoder() {
        var encoderDialogResult = EncoderDialog.startDialogAndGetResult();

        String ciphertext = encodeAndGetCipherText(
            encoderDialogResult.table(),
            encoderDialogResult.plainText(),
            encoderDialogResult.key()
        );

        println("");
        println("Зашифрованный исходный текст: " + ciphertext);
        println("");
    }

    private static void decoder() {
        var decoderDialogResult = DecoderDialog.startDialogAndGetResult();

        String plainText = decodeAndGetPlainText(
            decoderDialogResult.table(),
            decoderDialogResult.cipherText(),
            decoderDialogResult.key()
        );

        println("");
        println("Дешифрованный шифротекст: " + plainText);
        println("");
    }

    private static void printWelcomeMessage() {
        println("");
        println("==== ШИФР МАРШРУТНОЙ ПЕРЕСТАНОВКИ ====");
        println("");
        println("Для шифрования текста используется прямоугольная таблица.");
        println("Сначала исходный текст вписывается в таблицу по ходу одного «маршрута»,");
        println("а затем по ходу другого выписывается из неё. Маршруты предустановлены внутри программы.");
        println("");
    }
}
