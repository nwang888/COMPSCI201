import java.util.Collections;
import java.util.HashMap;

public class OverEnroll {
    public String[] popular(String[] data) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : data) {
            int firstI = str.indexOf(":");
            String name = str.substring(0,firstI);
            int secondI = str.indexOf(":", firstI + 1);
            int num = Integer.parseInt(str.substring(secondI + 1));
            map.putIfAbsent(str.substring(0,firstI), 0);
            map.put(name, map.get(name) + num);
        }

        int max = -1;
        int min = Integer.MAX_VALUE;
        String maxClass = "";
        String minClass = "";

        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxClass = key;
            }
            if (map.get(key) < min) {
                min = map.get(key);
                minClass = key;
            }
        }

        return new String[] {maxClass + ":" + max, minClass + ":" + min};
    }
}