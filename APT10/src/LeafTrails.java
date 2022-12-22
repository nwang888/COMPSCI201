import java.util.*;

public class LeafTrails {

    TreeMap<Integer,String> myMap = new TreeMap<>();

    public String[] trails(TreeNode tree) {
        doWork(tree, "");
        return myMap.values().toArray(new String[0]);
    }

    public void doWork(TreeNode tree, String path) {
        if (tree == null)
            return;
        if (tree.left == null && tree.right == null) {
            myMap.put(tree.info, path);
        }
        else {
            doWork(tree.left, path.concat("0"));
            doWork(tree.right, path.concat("1"));
        }
    }
}