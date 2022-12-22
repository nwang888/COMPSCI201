import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        //parallel character translated array
        String[] translated = new String[dictionary.length];
        char ch = 'A';
        for (int i = 0 ; i < translated.length ; i++) {
            translated[i] = Character.toString(ch);
            ch++;
        }

        //iterating through bits
        String bit = "";
        String ret = "";
        for (int i = 0 ; i < archive.length() ; i++) {
            bit += archive.substring(i,i+1);
            for (int k = 0 ; k < dictionary.length ; k ++)
                if (dictionary[k].equals(bit)) {
                    ret += translated[k];
                    bit = "";
                }
        }
        return ret;
    }
}