public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }

        p = head;
        ListNode prev = null;
        for (int i = 0; i < length / 2; i++) {
            prev = p;
            p = p.next;
        }
        prev.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(p);

        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (l != null || r != null) {
            if (l != null && r != null) {
                newTail.next = l.val < r.val ? l : r;
                newTail = newTail.next;
                if (l.val < r.val) {
                    l = l.next;
                } else {
                    r = r.next;
                }
            } else {
                newTail.next = l == null ? r : l;
                break;
            }
        }

        return newHead.next;
    }
}