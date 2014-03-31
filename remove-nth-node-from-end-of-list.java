public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode tail = head;
        for (int i = 1; i < n; i++) {
            tail = tail.next;
        }

        ListNode myhead = head;
        ListNode prev = null;
        while (tail.next != null) {
            prev = myhead;
            myhead = myhead.next;
            tail = tail.next;
        }

        if (prev == null) {
            return head.next;
        }

        prev.next = myhead.next;

        return head;
    }
}