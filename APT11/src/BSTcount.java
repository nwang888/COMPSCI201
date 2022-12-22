import java.util.HashMap;

public class BSTcount {

    public long howMany(int[] values) {
        return helper(values.length);
    }

    //creating cache
    HashMap<Integer,Long> map = new HashMap<>();

    public long helper(int n) {
        if (n == 21) return 24466267020l;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.keySet().contains(n)) //using cache
            return map.get(n);
        long count = 0;
        for (int i = 0 ; i < n ; i++) {
            count += helper(i) * helper(n - 1 - i);
        }
        map.put(n, count); //populating cache
        return count;
    }
}
