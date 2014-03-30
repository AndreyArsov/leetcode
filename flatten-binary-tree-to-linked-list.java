public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode[] helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode[] result = new TreeNode[2];
        TreeNode[] left = helper(root.left);
        TreeNode[] right = helper(root.right);

        result[0] = root;
        result[1] = root;
        root.left = null;
        root.right = null;

        if (left != null) {
            root.right = left[0];
            if (right != null) {
                left[1].right = right[0];
                result[1] = right[1];
            } else {
                left[1].right = null;
                result[1] = left[1];
            }
        } else if (right != null) {
            root.right = right[0];
            result[1] = right[1];
        }

        return result;
    }
}