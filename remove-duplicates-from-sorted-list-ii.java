public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode p = head;

        while (p != null) {
            boolean repeated = false;
            while (p != null && p.next != null && p.val == p.next.val) {
                p = p.next;
                repeated = true;
            }

            if (!repeated) {
                ListNode newNode = new ListNode(p.val);
                if (newHead == null) {
                    newHead = newNode;
                    newTail = newHead;
                } else {
                    newTail.next = newNode;
                    newTail = newNode;
                }
            }

            if (p != null) {
                p = p.next;
            }
        }

        return newHead;
    }
}