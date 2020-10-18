package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    @ParameterizedTest(name = "{0}: shift {1} by {2} to {3}")
    @CsvSource({
            "'input-null', , 1, ", "'input-null', a, , ",
            // zero loops
            "'empty-String', '', 1, ''", "'empty-String', '', -1, ''",
            // one loop
            "'valid-Char', a, 1, b", "'valid-Char', b, -1, a", "'valid-Char', z, 1, a", "'valid-Char', a, -1, z",
            // assuming space should translate to space
            "'valid-Char-space', ' ', 1, ' '", "'valid-String-containing-space', a a, 1, b b",
            // many loops
            "'valid-String', ab, 1, bc",
            "'invalid-Char-smaller-than-a', @, 1, invalid", "'invalid-Char-smaller-than-a', `, 1, invalid", "'invalid-Char-greater-than-z', {, 1, invalid",
            "'invalid-String', Aa, 1, invalid",
            "'traverse-end', z, 1, a", "'traverse-beginning', a, -1, z",
            // maybe needs update if we decide that space counts when shifting
            "'big-shift', a, 25, z", "'big-shift', a, 26, a", "'big-shift', a, 27, b"
    })
    public void testEncryption(String partition, String originalMessage, int encyptionShift, String expectedResult) {
        String result = new CaesarShiftCipher().CaesarShiftCipher(originalMessage, encyptionShift);
        Assertions.assertEquals(expectedResult, result);
    }
    @ParameterizedTest(name = "{0}: shift {1} by {2} and back")
    @CsvSource({
            "'valid-String', ab, 1",
            "'traverse-end', z, 1", "'traverse-beginning', a, -1"
    })
    public void testDecryption(String partition, String originalMessage, int encryptionShift) {
        String encryptedMessage = new CaesarShiftCipher().CaesarShiftCipher(originalMessage, encryptionShift);
        String decryptedMessage = new CaesarShiftCipher().CaesarShiftCipher(encryptedMessage, -1*encryptionShift);
        Assertions.assertEquals(originalMessage, decryptedMessage);
    }
}
