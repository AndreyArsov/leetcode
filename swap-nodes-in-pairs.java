public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        while (true) {
            p1.next = p2.next;
            if (prev != null) {
                prev.next = p2;
            } else {
                head = p2;
            }
            p2.next = p1;

            prev = p1;
            p1 = p1.next;
            if (p1 == null) {
                break;
            }

            p2 = p1.next;
            if (p2 == null) {
                break;
            }
        }

        return head;
    }
}