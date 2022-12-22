import java.util.ArrayList;
import java.util.Arrays;

public class HashTaggery {
    public String maxTag(String[] tags, String[] messages) {
        ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tags));
        int count = 0;
        for (String str : messages) {
            String[] words = str.replaceAll("[^a-zA-Z] && [#]", "").toLowerCase().split("\\s+");
            for (String s : words) {
                if (tagsList.contains(s.toLowerCase())) {
                    count++;
                    break;
                }
            }
        }
        if (count >= messages.length * 3.0/4)
            return "tagged";
        return "missed";
    }
}