public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        int p = 1;
        ListNode c = head;
        while (c != null) {
            if (m <= p && p <= (m + n) / 2) {
                ListNode other = c;
                for (int i = 0; i < n + m - 2 * p; i++) {
                    other = other.next;
                }
                int t = other.val;
                other.val = c.val;
                c.val = t;
            }

            c = c.next;
            p++;
        }

        return head;
    }
}