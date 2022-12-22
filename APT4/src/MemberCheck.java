import java.util.*;

public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {

        ArrayList<String> all = new ArrayList<>();
        Set<String> s1 = new HashSet<>(Arrays.asList(club1));
        Set<String> s2 = new HashSet<>(Arrays.asList(club2));
        Set<String> s3 = new HashSet<>(Arrays.asList(club3));

        all.addAll(s1);
        all.addAll(s2);
        all.addAll(s3);

        HashMap<String,Integer> map = new HashMap<>();
        for (String word : all) {
            map.putIfAbsent(word, 0);
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
        }

        ArrayList<String> ret = new ArrayList<>();

        for (String key : map.keySet())
            if (map.get(key) > 1)
                ret.add(key);

        Collections.sort(ret, String.CASE_INSENSITIVE_ORDER);
        String[] finalRet = new String[ret.size()];
        finalRet = ret.toArray(finalRet);

        return finalRet;
    }
}