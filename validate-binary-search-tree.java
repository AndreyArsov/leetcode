public class Solution {
    public boolean search(TreeNode node, int min, int max) {
        if (node.left == null && node.right == null) {
            return node.val < max && node.val > min;
        }

        return (node.left == null || (node.val > node.left.val && search(node.left, min, node.val))) &&
               (node.right == null || (node.val < node.right.val && search(node.right, node.val, max)));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return search(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}