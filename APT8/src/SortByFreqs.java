import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str: data) {
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }
        ArrayList<Map.Entry<String, Integer>> entrySet = new ArrayList<>(map.entrySet());
        Collections.sort(entrySet, Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0 ; i < entrySet.size() ; i++) {
            ret.add(entrySet.get(i).getKey());
        }
        return ret.toArray(new String[0]);
    }
}