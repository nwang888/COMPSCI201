import java.util.ArrayList;

public class AllPaths {

    ArrayList<String> arr = new ArrayList<>();

    public String[] paths(TreeNode t) {
        // replace with working code
        return new String[0];
    }

    public void recurse(TreeNode root, int index) {
        if (root == null)
            return;
        arr.get(index).concat("" + root.info + "->");
        recurse(root.left, index);

        recurse(root.right, index);
    }
}