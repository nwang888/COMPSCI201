import java.util.HashSet;
import java.util.TreeSet;

public class Closet {
    public String anywhere(String[] list) {
        TreeSet<String> retained = new TreeSet<>();

        for (String word : list[0].split(" "))
            retained.add(word);

        for (int i = 1 ; i < list.length ; i++) {
            HashSet<String> cur = new HashSet<>();
            for (String word : list[i].split(" "))
                cur.add(word);
            retained.addAll(cur);
        }

        return String.join( " ", retained);
    }
}
