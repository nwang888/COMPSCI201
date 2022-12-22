import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueNewYork {
    public int seen(String[] records) {
        ArrayList<String> cleaned = new ArrayList<String>();
        for (String record : records)
            cleaned.addAll(Arrays.asList(record.split(",")));
        HashSet<String> set = new HashSet<String>(cleaned);
        return set.size();
    }
}