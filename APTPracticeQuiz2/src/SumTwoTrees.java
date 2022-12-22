public class SumTwoTrees {
    public TreeNode add(TreeNode a, TreeNode b) {
        if (b == null && a == null)
            return null;
        else if (a != null && b == null)
            return a;
        else if (b != null && a == null)
            return b;
        return new TreeNode(a.info + b.info, add(a.left, b.left), add(a.right, b.right));
    }
}
