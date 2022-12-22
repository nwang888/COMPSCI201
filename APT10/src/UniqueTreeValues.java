import java.util.TreeSet;

public class UniqueTreeValues {
    TreeSet<Integer> mySet = new TreeSet<>();
    public int[] unique(TreeNode root) {
        recurse(root);
        //return mySet.toArray(new Integer[0]);
        int[] ret = new int[mySet.size()];
        int i = 0;
        for (Integer x: mySet) {
            ret[i] = x;
            i++;
        }
        return ret;
    }

    public void recurse(TreeNode root) {
        if (root == null)
            return;
        recurse(root.left);
        mySet.add(root.info);
        recurse(root.right);
    }
}