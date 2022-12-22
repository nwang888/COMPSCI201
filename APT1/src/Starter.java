import java.util.HashSet;

public class Starter {
    public int begins(String[] words, String first) {
        HashSet<String> uniqueWords = new HashSet<>();
        for (String w : words)
            if (w.substring(0,1).equals(first))
                uniqueWords.add(w);
        return uniqueWords.size();
    }
}