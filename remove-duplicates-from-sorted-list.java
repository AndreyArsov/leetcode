public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode prev = null;
        while (head != null) {
            if (newHead == null) {
                newHead = new ListNode(head.val);
                prev = newHead;
            } else if (head.val != prev.val) {
                ListNode newNode = new ListNode(head.val);
                prev.next = newNode;
                prev = newNode;
            }
            head = head.next;
        }

        return newHead;
    }
}