public class OddishTreeCount {
    public int count(TreeNode tree) {
        if (tree == null)
            return 0;
        if (tree.info % 2 == 1)
            return 1 + count(tree.left) + count(tree.right);
        return count(tree.left) + count(tree.right);
    }
}