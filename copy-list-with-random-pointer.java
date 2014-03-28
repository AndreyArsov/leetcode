public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }

        p = head;
        while (p != null) {
            RandomListNode pp = map.get(p);
            if (p.next != null) {
                pp.next = map.get(p.next);
            }
            if (p.random != null) {
                pp.random = map.get(p.random);
            }
            p = p.next;
        }

        return map.get(head);
    }
}