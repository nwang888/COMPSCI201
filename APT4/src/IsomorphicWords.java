import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicWords {
    public int countPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < words.length ; i++) {
            words[i] = encrypt(words[i]);
        }
        for (int i = 0 ; i < words.length ; i++) {
            map.putIfAbsent(words[i],0);
            map.put(words[i],map.get(words[i])+1);
        }
        int count = 0;
        for (String word : words)
            count += map.get(word);
        return count;
    }

    private String encrypt(String message){
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