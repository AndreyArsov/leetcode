public class Solution {
    private int length(ListNode node) {
        ListNode n = node;
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode answer = null;
        ListNode last = null;
        int carry = 0;
        while (c1 != null || c2 != null) {
            int sum = (c1 == null ? 0 : c1.val) + (c2 == null ? 0 : c2.val) + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            if (answer == null) {
                answer = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }

        if (carry > 0) {
             ListNode newNode = new ListNode(1);
             if (answer == null) {
                 answer = newNode;
                 last = newNode;
             } else {
                 last.next = newNode;
                 last = newNode;
             }
        }
        return answer;
    }
}