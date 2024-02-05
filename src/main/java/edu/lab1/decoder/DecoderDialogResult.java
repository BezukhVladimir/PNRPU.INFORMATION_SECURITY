package edu.lab1.decoder;

import edu.lab1.models.Table;

public record DecoderDialogResult(
    Table table,
    String ciphertext,
    String key
) {
}
