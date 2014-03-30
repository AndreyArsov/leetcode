public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return search(num, 0, num.length - 1);
    }

    private TreeNode search(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        int median = (left + right) / 2;
        TreeNode n = new TreeNode(num[median]);
        n.left = search(num, left, median - 1);
        n.right = search(num, median + 1, right);
        return n;
    }
}