public class TreeSumTotal {
    public int count(TreeNode tree, int target) {
        if (tree == null)
            return 0;
        if (sum(tree) == target)
            return 1 + count(tree.left, target) + count(tree.right, target);
        return count(tree.left, target) + count(tree.right, target);
    }

    public int sum(TreeNode tree) {
        if (tree == null)
            return 0;
        return tree.info + sum(tree.right) + sum(tree.left);
    }
}