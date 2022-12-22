import java.util.*;

public class Ograph {
    ArrayList<Set<Integer>> graph;
    Set<Integer> visited;

    public int[] components(String[] data) {
        graph = new ArrayList<Set<Integer>>();
        visited = new HashSet<Integer>();

        //add filler elements to graph
        for (String str : data)
            graph.add(null);

        //add contents to graph
        for (int r = 0 ; r < data.length ; r++) {
            Set<Integer> set = new HashSet<>();
            for (String str : data[r].split(" ")) {
                set.add(Integer.parseInt(str));
            }
            graph.set(r, set);
        }

        ArrayList<Integer> counts = new ArrayList<>();

        while (visited.size() != graph.size()) {
            Queue<Integer> q = new LinkedList<>();

            int firstNotVisited = -1;
            for (int i = 0 ; i < graph.size() ; i++)
                if (!visited.contains(graph.get(i))) {
                    firstNotVisited = i;
                    break;
                }

            q.add(firstNotVisited);
            int count = 0;
            while (q.size() > 0) {
                int index = q.remove();
                visited.add(index);
                for (int x : graph.get(index))
                    if (!visited.contains(x)) {
                        q.add(x);
                    }
            }
            counts.add(count);
        }

        int[] ret = new int[counts.size()];
        for (int i = 0 ; i < counts.size() ; i++)
            ret[i] = counts.get(i);
        return ret;
    }
}