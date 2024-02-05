package edu.lab1;

import edu.lab1.decoder.Decoder;
import edu.lab1.encoder.Encoder;
import edu.lab1.models.Table;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.regex.Matcher;
import static org.assertj.core.api.Assertions.assertThat;

public final class EncoderAndDecoderTest {
    private EncoderAndDecoderTest() {
    }

    /*
     *       |при|
     *       |вет|
     *       | wo|
     *       |rld|
     *
     *        231
     */
    @Test
    void encodeAndDecode() {
        // Arrange
        Table table = new Table(3, 4);
        String expectedPlainText = "привет world";
        String key = "231";
        String expectedCiphertext = "итodпв rреwl";


        // Act
        String ciphertext = Encoder.encodeAndGetCipherText(table, expectedPlainText, key);
        String plainText  = Decoder.decodeAndGetPlainText(table, expectedCiphertext, key);

        // Assert
        assertThat(ciphertext).isEqualTo(expectedCiphertext);
        assertThat(plainText).isEqualTo(expectedPlainText);
    }
}
