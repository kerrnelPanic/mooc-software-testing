package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) throws Exception {

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            Integer currentNumber = map.get(s.charAt(i));
            Integer next = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;
            Integer secondNext = i + 2 < s.length() ? map.get(s.charAt(i + 2)) : 0;

            if (currentNumber.equals(next) && currentNumber.equals(secondNext)) {
                convertedNumber += currentNumber + next + secondNext;
                i+=2;
            }
            else if (currentNumber.equals(next) && currentNumber > secondNext) {
                convertedNumber += currentNumber + next;
                i++;
            }
            else if (currentNumber < next) {
                convertedNumber += next - currentNumber;
                i++;
            }
            else if(currentNumber > next)
                convertedNumber += currentNumber;
            else
                throw new Exception("Invalid roman number");
        }

        return convertedNumber;

    }
}
