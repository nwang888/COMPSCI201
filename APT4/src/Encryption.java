import java.util.HashMap;

public class Encryption {
    public String encrypt(String message){
        HashMap<Character,String> map = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ret = "";
        int uniqueCount = 0;
        for (char ch : message.toCharArray()) {
            if (!map.containsKey(ch)) {
                String encoded = alphabet.substring(uniqueCount,uniqueCount + 1);
                map.putIfAbsent(ch, encoded);
                uniqueCount++;
                ret += encoded;
            }
            else
                ret += map.get(ch);
        }
        return ret;
    }
}