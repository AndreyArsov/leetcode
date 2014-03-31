public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        } else if (k == 1) {
            return head;
        }

        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (length < k) {
            return head;
        }

        p = head;
        Stack s = new Stack();
        ListNode newHead = null;
        ListNode newTail = null;

        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k; j++) {
                s.push(p);
                p = p.next;
            }

            for (int j = 0; j < k; j++) {
                ListNode n = (ListNode)(s.pop());
                if (newHead == null) {
                    newHead = n;
                    newTail = n;
                } else {
                    newTail.next = n;
                    newTail = n;
                }
            }
        }

        newTail.next = p;
        return newHead;
    }
}