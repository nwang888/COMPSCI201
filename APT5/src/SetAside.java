import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class SetAside {
    public String common(String[] list) {
        TreeSet<String> retained = new TreeSet<>();

        for (String word : list[0].split(" "))
            retained.add(word);

        for (int i = 1 ; i < list.length ; i++) {
            HashSet<String> cur = new HashSet<>();
            for (String word : list[i].split(" "))
                cur.add(word);
            retained.retainAll(cur);
        }

        return String.join( " ", retained);
    }
}