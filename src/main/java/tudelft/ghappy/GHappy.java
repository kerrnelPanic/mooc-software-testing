package tudelft.ghappy;

public class GHappy {

    public boolean gHappy(String str) {
        //at the moment, our method just fails on null
        assert str!=null;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'g') {
                //here's the bug, we try to access index -1 of the char array
                if (i >= 0 && str.charAt(i-1) == 'g') { continue; }
                if (i+1 < str.length() && str.charAt(i+1) == 'g') { continue; }
                return false;
            }
        }
        //we reach this statement also if there is no g in the evaluated string
        return true;

    }
}
