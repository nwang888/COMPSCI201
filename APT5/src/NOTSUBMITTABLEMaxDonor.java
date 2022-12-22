import java.util.HashMap;

public class NOTSUBMITTABLEMaxDonor {
    public String generous(String[] orgs, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < orgs.length ; i++)
            map.putIfAbsent(orgs[i], amount[i]);
        int max = 0;
        String smax = "";
        for (String key : map.keySet())
            if (map.get(key) > max) {
                max = map.get(key);
                smax = key;
            }
        return smax + ":" + max;
    }
}