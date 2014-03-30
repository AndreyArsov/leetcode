public class Solution {
    private int testBalance(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = 0;
        if (root.left != null) {
            leftHeight = testBalance(root.left);
        }

        int rightHeight = 0;
        if (root.right != null) {
            rightHeight = testBalance(root.right);
        }

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return testBalance(root) != -1;
    }
}