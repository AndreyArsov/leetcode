public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Stack s = new Stack();
        ListNode p = head;
        while (p != null) {
            s.push(p);
            p = p.next;
        }

        p = head;
        while (p.next != null && p.next.next != null) {
            ListNode top = (ListNode)(s.pop());
            ((ListNode)s.peek()).next = null;
            ListNode nextP = p.next;
            p.next = top;
            top.next = nextP;
            p = nextP;
        }
    }
}