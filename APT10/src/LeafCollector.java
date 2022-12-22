import java.util.ArrayList;
import java.util.List;

public class LeafCollector {
    public String[] getLeaves(TreeNode tree) {
        ArrayList<String> ret = new ArrayList<>();
        while (tree != null) {
            ArrayList<String> round = new ArrayList<>();
            tree = removeLeaves(tree, round);
            String s = String.join(" ", round);
            ret.add(s);
        }
        return ret.toArray(new String[0]);
    }

    private TreeNode removeLeaves(TreeNode tree, ArrayList<String> list) {
        if (tree == null) return null;
        if (tree.left == null && tree.right == null) {
            list.add("" + tree.info);
            return null;
        }
        tree.left = removeLeaves(tree.left, list);
        tree.right = removeLeaves(tree.right, list);
        return tree;
    }
}
