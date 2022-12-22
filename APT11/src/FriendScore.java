import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FriendScore {

    HashMap<Integer, Set<Integer>> graph = new HashMap<>();

    public int highestScore(String[] friends) {
        //add contents to graph
        for (int r = 0 ; r < friends.length ; r++) {
            HashSet<Integer> set = new HashSet<>();
            for (int c = 0 ; c < friends.length ; c++) {
                if (friends[r].substring(c, c+1).equals("Y"))
                    set.add(c);
            }
            graph.put(r, set);
        }

        //iterate through and get max
        int maxFriends = -1;
        for (int i = 0 ; i < friends.length ; i++) {
            int cur = twoFriends(i).size();
            if (Math.max(cur, maxFriends) == cur)
                maxFriends = cur;
        }
        return maxFriends;
    }

    private Set<Integer> twoFriends(int index) {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> friends = graph.get(index);
        set.addAll(friends);
        for (int friend : friends)
            set.addAll(graph.get(friend));
        set.remove(index);
        return set;
    }
}