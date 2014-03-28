public class Solution {
    private int sum = 0;

    private void search(TreeNode node, int current) {
        if (node.left == null && node.right == null) {
            sum += current * 10 + node.val;
            return;
        }

        if (node.left != null) {
            search(node.left, current * 10 + node.val);
        }

        if (node.right != null) {
            search(node.right, current * 10 + node.val);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum = 0;
        search(root, 0);
        return sum;
    }
}