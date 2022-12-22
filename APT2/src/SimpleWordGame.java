import java.util.HashMap;
import java.util.HashSet;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        HashSet<String> hash = new HashSet<String>();
        HashSet<String> uniquePlayer = new HashSet<String>();
        int score = 0;
        for (String str : dictionary)
            hash.add(str);
        for (String str : player)
            uniquePlayer.add(str);
        for (String str: uniquePlayer) {
            int originalSize = hash.size();
            hash.add(str);
            if (hash.size() == originalSize)
                score+= str.length() * str.length();
        }
        return score;
    }
}