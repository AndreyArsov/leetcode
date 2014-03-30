public class Solution {
    private int min = Integer.MAX_VALUE;

    private void search(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
            return;
        }

        if (node.left != null) {
            search(node.left, depth + 1);
        }

        if (node.right != null) {
            search(node.right, depth + 1);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        search(root, 1);
        return min;
    }
}