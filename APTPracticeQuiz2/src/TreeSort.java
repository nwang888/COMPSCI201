import java.util.ArrayList;
import java.util.Arrays;

public class TreeSort {
    ArrayList<Integer> arr = new ArrayList<>();
    public int[] sort(TreeNode tree) {
        recurse(tree);
        int[] ret = new int[arr.size()];
        for (int i = 0 ; i < arr.size() ; i++)
            ret[i] = arr.get(i);
        Arrays.sort(ret);
        return ret;
    }

    public void recurse(TreeNode tree) {
        if (tree == null)
            return;
        arr.add(tree.info);
        recurse(tree.left);
        recurse(tree.right);
    }
}