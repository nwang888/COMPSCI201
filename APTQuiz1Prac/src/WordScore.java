import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordScore {
    public int[] score(String[] words, String want, String avoid) {
        int[] ret = new int[words.length];

        HashSet<Character> wantCleaned = new HashSet<>();
        HashSet<Character> avoidCleaned = new HashSet<>();
        for (char ch : want.toCharArray())
            wantCleaned.add(ch);
        for (char ch : avoid.toCharArray())
            avoidCleaned.add(ch);

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : wantCleaned) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        for (char ch : avoidCleaned) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) - 1);
        }

        for (int i = 0 ; i < words.length ; i++) {
            int wordScore = 0;
            for (char ch : words[i].toCharArray())
                if (map.get(ch) != null)
                    wordScore += map.get(ch);
            ret[i] = wordScore;
        }
        return ret;
    }
}