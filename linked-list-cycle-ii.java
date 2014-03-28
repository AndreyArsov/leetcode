public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head;

        while (true) {
            node1 = node1.next;
            if (node1 == null) {
                return null;
            }
            if (node2.next == null) {
                return null;
            }
            node2 = node2.next.next;
            if (node2 == null) {
                return null;
            }
            if (node1 == node2) {
                ListNode n1 = head;
                ListNode n2 = node1;
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n1;
            }
        }
    }
}