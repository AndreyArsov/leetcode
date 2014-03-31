public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode merged = null;
        ListNode prev = null;
        while (l1 != null || l2 != null) {
            ListNode newNode;
            if (l1 == null) {
                newNode = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                newNode = l1;
                l1 = l1.next;
            } else {
                if (l1.val > l2.val) {
                    newNode = l2;
                    l2 = l2.next;
                } else {
                    newNode = l1;
                    l1 = l1.next;
                }
            }

            if (merged == null) {
                merged = newNode;
                prev = newNode;
            } else {
                prev.next = newNode;
                prev = newNode;
            }
        }

        return merged;
    }
}