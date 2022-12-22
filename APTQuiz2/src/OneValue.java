public class OneValue {
    int count = 0;
    public int count(TreeNode tree) {
        retHelper(tree);
        return count;
    }

    public void retHelper(TreeNode tree) {
        if (tree == null)
            return;
        if (isUnique(tree)) {
            count += countUnique(tree);
            return;
        }
        retHelper(tree.left);
        retHelper(tree.right);
    }

    //precond tree is not null
    public int helper(TreeNode tree) {
        if (tree.left == null && tree.right == null)
            if (tree.left.info == tree.right.info)
                return tree.left.info;
        else if (tree.left == null)
            if (tree.info == helper(tree.right))
                return tree.info;
        else if (tree.right == null)
            if (tree.info == helper(tree.left))
                return tree.info;
        else if (tree.right != null && tree.left != null)
            if (tree.info == helper(tree.left) && tree.info == helper(tree.right))
                return tree.info;
        return -1;
    }

    //Precondition: tree is unique
    public int countUnique(TreeNode tree) {
        if (tree == null)
            return 0;
        return 1 + countUnique(tree.left) + countUnique(tree.right);
    }

    public boolean isUnique(TreeNode tree) {
        if (tree.left != null && tree.right != null)
            return tree.info == helper(tree.left) && tree.info == helper(tree.right);
        if (tree.left == null && tree.right != null)
            return tree.info == helper(tree.right);
        if (tree.left != null && tree.right == null)
            return tree.info == helper(tree.left);
        return false;
    }
}