public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode node1 = head;
        ListNode node2 = head;

        while (true) {
            node1 = node1.next;
            if (node1 == null) {
                return false;
            }
            if (node2.next == null) {
                return false;
            }
            node2 = node2.next.next;
            if (node2 == null) {
                return false;
            }
            if (node1 == node2) {
                return true;
            }
        }
    }
}