public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }

        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (length == 1) {
            return head;
        }

        n %= length;
        if (n == 0) {
            return head;
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

        tail.next = head;

        if (prev != null) {
            prev.next = null;
        }

        return myhead;
    }
}