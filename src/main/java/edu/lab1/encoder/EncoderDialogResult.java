package edu.lab1.encoder;

import edu.lab1.models.Table;

public record EncoderDialogResult(
    Table table,
    String plaintext,
    String key
) {
}
