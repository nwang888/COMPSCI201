import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortedLeaves {
    private ArrayList<String> ret = new ArrayList<>();

    public String[] values(TreeNode tree) {
        getNums(tree);
        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    private void getNums(TreeNode tree) {
        if (tree == null)
            return;
        if (tree.left == null && tree.right == null) {
            ret.add(Character.toString((char) tree.info));
            return;
        }
        getNums(tree.left);
        getNums(tree.right);
    }
}