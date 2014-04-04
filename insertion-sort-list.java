public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode current = head.next;
        while (prev != null && prev.next != null) {
            current = prev.next;
            if (prev.val <= current.val) {
                prev = prev.next;
                continue;
            }

            prev.next = current.next;

            if (head.val > current.val) {
                current.next = head;
                head = current;
                prev = head;
                continue;
            }

            ListNode prevP = null;
            ListNode p = head;
            while (p != null && p.val <= current.val) {
                prevP = p;
                p = p.next;
            }

            current.next = p;
            prevP.next = current;
            prev = head;
        }

        return head;
    }
}