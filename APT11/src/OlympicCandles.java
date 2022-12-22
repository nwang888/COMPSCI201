import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OlympicCandles{
    public int numberOfNightsBad(int[] candles){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int len : candles)
            pq.add(len);

        int nights = 0;

        while (true) {
            ArrayList<Integer> holding = new ArrayList<>();
            for (int i = 0 ; i < nights ; i++) {
                int max = pq.remove();
                if (max == 0)
                    return nights - 1;
                max--;
                holding.add(max);
            }

            for (int held : holding)
                pq.add(held);

            nights++;
        }
    }
    public int numberOfNights(int[] candles) {
        int nc = candles.length;
        for (int night = 1 ; night <= nc ; night++) {
            Arrays.sort(candles);
            for (int j = nc - 1 ; j >= nc - night ; j--) {
                if (candles[j] <= 0)
                    return night - 1;
                candles[j]-- ;
            }
        }
        return nc;
    }
}