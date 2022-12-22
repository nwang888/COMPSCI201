public class TreeBuilder {
    public TreeNode create(int[] values) {
        return helper(values, 0);
    }

    private TreeNode helper(int[] vals, int index) {
        if (index >= vals.length)
            return null;
        return new TreeNode(vals[index], helper(vals, 2*index + 1), helper(vals, 2*index + 2));
    }
}