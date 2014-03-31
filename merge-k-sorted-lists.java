public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode result = null;
        ListNode answer = null;

        boolean added = true;
        while (added) {
            added = false;

            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < lists.size(); i++) {
                ListNode head = lists.get(i);
                if (head != null && head.val < min) {
                    min = head.val;
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                ListNode minNode = lists.get(minIndex);
                lists.set(minIndex, minNode.next);
                if (result == null) {
                    result = minNode;
                    answer = minNode;
                } else {
                    result.next = minNode;
                    result = minNode;
                }
                added = true;
            }
        }

        return answer;
    }
}