import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Follower {
    /*public int[] follows(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String str : words) {
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str) + 1);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                ret.add(map.get(key) - 1);
            }
        }
        int[] r = new int[ret.size()];
        for (int i = 0 ; i < ret.size() ; i++)
            r[i] = ret.get(i);
        Arrays.sort(r);
        return r;
    }*/
    public int[] follows(String[] words) {
        ArrayList<Integer> indexRet = new ArrayList<>();
        for (int i = 0 ; i < words.length; i++) {
            for (int k = i + 1 ; k < words.length ; k++) {
                if (words[i].equals(words[k])) {
                    indexRet.add(i);
                    break;
                }
            }
        }
        int[] ret = new int[indexRet.size()];
        for (int i = 0 ; i < indexRet.size() ; i++)
            ret[i] = indexRet.get(i);
        Arrays.sort(ret);
        return ret;

    }
}
