import java.util.Comparator;
import java.util.PriorityQueue;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        if (votes.length == 1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int k = 1 ; k < votes.length ; k++) // dont add yourself to pq
            pq.add(votes[k]);

        int steal = 0;
        while (true) {
            int max = pq.remove();
            if (votes[0] > max)break;

            max--;
            pq.add(max);
            steal++;
            votes[0]++;
        }
        return steal;
    }
}