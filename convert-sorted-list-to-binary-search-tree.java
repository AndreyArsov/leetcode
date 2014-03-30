public class Solution {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        current = head;

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        return search(0, len - 1);
    }

    private TreeNode search(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode leftChild = search(left, mid - 1);
        TreeNode newNode = new TreeNode(current.val);
        current = current.next;
        TreeNode rightChild = search(mid + 1, right);
        newNode.left = leftChild;
        newNode.right = rightChild;

        return newNode;
    }
}