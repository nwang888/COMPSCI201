public class HeightLabel {
    /*public TreeNode rewire(TreeNode root) {
        if (root == null) return null;
        TreeNode ret = new TreeNode (0,
                rewire(root.left),
                rewire(root.right));
        int lh = 0;
        int rh = 0;
        if (ret.left != null)
            lh = ret.left.info;
        if (ret.right != null)
            lh = ret.right.info;
        ret.info = 1 + Math.max(lh, rh);
        return ret;
    }*/

    public TreeNode rewire(TreeNode t) {
        if (t == null)
            return null;
        return new TreeNode(height(t), rewire(t.left), rewire(t.right));
    }

    private int height(TreeNode t) {
        if (t == null)
            return 0;
        return 1 + Math.max(height(t.left), height(t.right));
    }
}