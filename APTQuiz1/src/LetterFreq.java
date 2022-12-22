import java.util.HashMap;

public class LetterFreq {
    public String findFreqs(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (Character ch : alphabet.toCharArray())
            map.putIfAbsent(ch, 0);

        for (String str : words)
            for (Character ch : str.toCharArray()) {
                if (map.get(ch) != null)
                    map.put(ch, map.get(ch) + 1);
            }

        String ret = "";
        for (Character key : map.keySet())
            ret += map.get(key) + ":";

        return ret.substring(0, ret.length() - 1);
    }
}