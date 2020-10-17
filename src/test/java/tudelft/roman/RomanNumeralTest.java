package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {

    private RomanNumeral roman;

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() throws Exception {

        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() throws Exception {

        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() throws Exception {

        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void invalidNumberWithSeveralSubtractiveNotation() {
        String exception = "Invalid roman number";

        Assertions.assertThrows(Exception.class, () -> {
            roman.convert("IIV");
        });
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() throws Exception {

        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

}
