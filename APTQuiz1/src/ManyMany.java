import java.util.*;

public class ManyMany {
    /*public String[] filter(String[] data){
        ArrayList<String> ret = new ArrayList<>();
        for (String str : data) {
            HashSet<String> set = new HashSet<>();
            for (String ch : str.split(" "))
                set.add(ch);
            ret.add(String.join(" ", set));
            ArrayList<String> arr = new ArrayList<>();

        }
        String[] finalRet = ret.toArray(new String[0]);
        return finalRet;
    }*/
    public String[] filter(String[] data) {
        ArrayList<String> ret = new ArrayList<>();
        for (String str : data) {
            TreeMap<String, Integer> map = new TreeMap<>();
            for (String ch : str.split(" ")) {
                map.putIfAbsent(ch, 0);
                map.put(ch, map.get(ch) + 1);
            }
            ArrayList<String> keyRet = new ArrayList<>();
            for (String key : map.keySet()) {
                if (map.get(key) > 1)
                    keyRet.add(key);
            }
            ret.add(String.join(" ", keyRet));
        }
        String[] finalRet = ret.toArray(new String[0]);
        return finalRet;
    }
}