public class OneValuePastTime {
    public int count(TreeNode tree) {
        if (tree == null)
            return 0;
        if (isUnique(tree,tree.info))
            return 1 + count(tree.left) + count(tree.right);
        return count(tree.left) + count(tree.right);
    }

    public boolean isUnique(TreeNode tree, int i) {
        if (tree.right == null && tree.left == null)
            return true;
        return isUnique(tree.right, i) && isUnique(tree.left, i);
    }
}