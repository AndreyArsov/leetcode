public class Solution {
    private int max;

    private void search(TreeNode node, int depth) {
        if (node == null) {
            if (depth - 1 > max) {
                max = depth - 1;
            }
            return;
        }

        search(node.left, depth + 1);
        search(node.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {
        max = -1;
        search(root, 1);
        return max;
    }
}