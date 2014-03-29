public class Solution {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        search(root);
        return max;
    }

    private int search(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = search(node.left);
        int maxRight = search(node.right);

        int choice1 = maxLeft + maxRight + node.val;
        int choice2 = maxLeft + node.val;
        int choice3 = maxRight + node.val;
        int choice4 = node.val;
        int bestChoice = Math.max(choice1, Math.max(choice2, Math.max(choice3, choice4)));
        max = Math.max(max, bestChoice);

        return Math.max(choice4, Math.max(choice2, choice3));
    }
}