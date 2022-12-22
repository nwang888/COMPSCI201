import java.util.HashMap;

public class Infrequent {
    public String find(String[] phrases){
        HashMap<String, Integer> map = new HashMap<>();
        for (String phrase : phrases)
            for (String word : phrase.split(" ")) {
                map.putIfAbsent(word.toLowerCase(), 0);
                map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
            }
        int minCount = Integer.MAX_VALUE;
        String minString = "";
        for (String key : map.keySet())
            if (map.get(key) < minCount) {
                minCount = map.get(key);
                minString = key;
            }
        return minString;
    }
}