import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Aaagmnrs {
/*    public String[] anagrams(String[] phrases) {
        String[] sorted = new String[phrases.length];
        boolean[] flag = new boolean[phrases.length];
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0 ; i < phrases.length ; i++) {
            flag[i] = false;
            String[] charArr = phrases[i].toLowerCase().replaceAll(" ", "").split(" ");
            Arrays.sort(charArr);
            sorted[i] = (String.join(" ", charArr));
        }

        for (int i = 0 ; i < sorted.length ; i++) {
            for (int j = i + 1 ; j < sorted.length ; j++)
                if (sorted[i] == sorted[j] && !flag[i]) {
                    ret.add(phrases[i]);
                    flag[i] = true;
                    flag[j] = true;
                }
        }
        return ret.toArray(new String[0]);
    }*/

    public String[] anagrams(String[] phrases) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0 ; i < phrases.length ; i++) {
            String[] charArr = phrases[i].toLowerCase().split(" ");
            Arrays.sort(charArr);
            String key = String.join(" ", charArr);
            map.putIfAbsent(key, 0);
            if (map.get(key) > 0)
                ret.add(phrases[i]);
            else map.put(key, map.get(key) + 1);
        }
        return ret.toArray(new String[0]);
    }

    /*public String[] anagrams(String[] phrases) {
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList(phrases));
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0 ; i < aList.size() ; i++)
            for (int j = i + 1 ; j < aList.size() ; j++)
                if (equals(aList.get(i), aList.get(j))) {
                    ret.add(aList.get(j));

                }
        return phrases;
    }

    private boolean equals(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.asList(char1).equals(Arrays.asList(char2));
    }*/
}