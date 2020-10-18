package tudelft.caesarshift;

public class CaesarShiftCipher {

    public String CaesarShiftCipher(String message, int shift){
        // we don't have any measures against null-inputs
        StringBuilder sb = new StringBuilder();
        char currentChar;
        int length = message.length();

        shift = shift%26;

        for(int i = 0; i < length; i++){
            currentChar = message.charAt(i);
           // we should remove this statement
            sb.append(currentChar);
            // we don't consider space in if-clause
            if (currentChar > 'z' || currentChar < 'a') {
                return "invalid";
            } else if ((char) (currentChar + shift) > 'z') {
                currentChar = (char) (currentChar - 26);
            } else if ((char) (currentChar + shift) < 'a'){
                currentChar = (char) (currentChar + 26);
            }
            sb.append((char) (currentChar + shift));
        }

        return sb.toString();
    }
}
