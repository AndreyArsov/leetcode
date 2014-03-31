public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = null;
        ListNode smallEnd = null;
        ListNode big = null;
        ListNode bigEnd = null;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                if (small == null) {
                    small = new ListNode(current.val);
                    smallEnd = small;
                } else {
                    ListNode newNode = new ListNode(current.val);
                    smallEnd.next = newNode;
                    smallEnd = newNode;
                }
            } else {
                if (big == null) {
                    big = new ListNode(current.val);
                    bigEnd = big;
                } else {
                    ListNode newNode = new ListNode(current.val);
                    bigEnd.next = newNode;
                    bigEnd = newNode;
                }
            }

            current = current.next;
        }

        if (smallEnd != null) {
            smallEnd.next = big;
            return small;
        } else {
            return big;
        }
    }
}