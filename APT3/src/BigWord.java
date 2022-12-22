import java.util.*;

public class BigWord {
    public String most(String[] sentences) {
        ArrayList<String> arr = new ArrayList<String>();
        for (String s : sentences)
            arr.addAll(Arrays.asList(s.toLowerCase().split(" ")));
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.putIfAbsent(s, 0);
            map.put(s,map.get(s)+1);
        }
        int max = Collections.max(map.values());
        for (String s : map.keySet())
            if (map.get(s) == max)
                return s;

        return "error";
    }
}