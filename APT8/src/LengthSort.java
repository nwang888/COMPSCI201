import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
    public String[] rearrange(String[] values){
        Arrays.sort(values);
        Arrays.sort(values, Comparator.comparing(String::length));
        return values;
    }
}