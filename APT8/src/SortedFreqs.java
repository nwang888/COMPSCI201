import java.sql.Array;
import java.util.*;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        ArrayList<String> freq = new ArrayList<>(Arrays.asList(data));
        TreeSet<String> set = new TreeSet<>(Arrays.asList(data));
        int[] ret = new int[set.size()];
        int i = 0;
        for (String str : set) {
            ret[i] = Collections.frequency(freq, str);
            i++;
        }
        return ret;
    }
}