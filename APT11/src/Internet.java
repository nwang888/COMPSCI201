import java.util.*;

public class Internet {
    ArrayList<Set<Integer>> graph;
    public int articulationPoints(String[] routers) {
        graph = new ArrayList<Set<Integer>>(routers.length);
        //add contents to graph
        for (int r = 0 ; r < routers.length ; r++) {
            HashSet<Integer> set = new HashSet<>();
            for (int c = 0 ; c < routers.length ; c++) {
                if (routers[r].substring(c, c+1).equals("Y"))
                    set.add(c);
            }
            graph.set(r, set);
        }

    }

    private Set<String> reachFromSkip(String start, String avoid) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);
        visited.add(start);
        while (stack.size() > 0) {
            String v = stack.pop();
            for (String adj : graph.get(v)) {

            }
        }
    }
}
