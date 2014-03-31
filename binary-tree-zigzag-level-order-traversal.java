import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return answer;
        }

        boolean reverse = false;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.push(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            ArrayDeque<TreeNode> newNodes = new ArrayDeque<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                thisLevel.add(n.val);
                if (n.left != null) {
                    newNodes.add(n.left);
                }

                if (n.right != null) {
                    newNodes.add(n.right);
                }
            }

            queue = newNodes;

            if (reverse) {
                Collections.reverse(thisLevel);
            }

            reverse = !reverse;
            answer.add(thisLevel);
        }

        return answer;
    }
}