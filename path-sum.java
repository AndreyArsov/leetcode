public class Solution {
    private int sum;

    private boolean search(TreeNode node, int currentSum) {
        if (node.left == null && node.right == null) {
            return currentSum == this.sum;
        }

        if (node.left != null) {
            if (search(node.left, currentSum + node.left.val)) {
                return true;
            }
        }

        if (node.right != null) {
            if (search(node.right, currentSum + node.right.val)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        this.sum = sum;
        return search(root, root.val);
    }
}