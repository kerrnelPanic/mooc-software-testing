package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    // what to do if no g's at all?
    @ParameterizedTest(name = "{0}: {1} => {2}")
    @CsvSource({
            // we do not know what to do if there is no g in the string or no string at all
            // at the moment, our method fails if supplied with null and evaluates to true if no g in string
            // I'd suppose, it should evaluate to false or return null if there is no g at all
            // str is null
            "'str-is-null', , 'f'",
            // loop is not executed at all
            "'str-length-zero','', 'f'",
            // loop is executed once
            "'str-length-one','a', 'f'",
            // loop is executed several times
            "'str-length-many','abc', 'f'",

            // one single g
            "'one-single-g', 'xgx', 'f'",
            // two single g
            "'two-single-g', 'xgxgx', 'f'",
            // g at fist and last position of list
            "g-at-first/last-position', 'gxg', 'f'",
            // one single g and one double g
            "'single-g-and-double-g', 'xgxggx', 'f'",
            // one double g only
            "'double-g-only', 'xggx', 't'"

    })
    public void testAlgorithm(String partition, String inputString, Character expectedResult) {
        boolean result = new GHappy().gHappy(inputString);
        Character resultString = result ? 't' : 'f';
        Assertions.assertEquals(expectedResult , resultString);
    }


}
