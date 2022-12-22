import java.util.ArrayList;
import java.util.Arrays;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders) {
        for (int i = 0 ; i < orders.length ; i++)
            if (Arrays.asList(available).containsAll(Arrays.asList(orders[i].split(" "))))
                return i;
        return -1;
    }
}