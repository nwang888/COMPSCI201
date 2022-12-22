import java.util.*;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> allowed = new ArrayList<>();
        ArrayList<String> repeat = new ArrayList<>();
        String myWord;
        int count = 0;
        for (int k = 0; k < list.length; k++) {
            if (!repeat.contains(list[k])) {
                myWord = list[k];
                if (myWord.length() >= minLength) {
                    allowed.add(list[k]);
                    count++;
                }
            }
            repeat.add(list[k]);
        }
        return allowed.toArray(new String[0]);
    }

    /*LinkedList<String> llist = new LinkedList<String>();

        for (String str : llist)
            if (str.length() >= minLength)
            if (!llist.contains(str))
            llist.add(str);

    String[] finalList = new String[llist.size()];
        llist.toArray(finalList);

        return finalList;*/

    /*public String[] filter(String[] list, int minLength) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : list) {
            map.putIfAbsent(s, false);
            if (s.length() >= minLength)
                map.put(s,true);
        }
        ArrayList<String> ret = new ArrayList<>();
        for (String s : map.keySet())
            if (map.get(s) == true)
                ret.add(s);
        return ret.toArray(new String[0]);
    }*/
}