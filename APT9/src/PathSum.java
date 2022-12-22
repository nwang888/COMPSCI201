public class PathSum {
    public int hasPath(int target, TreeNode tree) {
        if (sumPath(0, target, tree) > 0)
            return 1;
        return 0;
    }

    public int sumPath(int curSum, int target, TreeNode tree) {
        if (tree == null) {
            if (curSum == target)
                return 1;
            return 0;
        }
        return sumPath(curSum + tree.info, target, tree.left) + sumPath(curSum + tree.info, target, tree.right);
    }
}