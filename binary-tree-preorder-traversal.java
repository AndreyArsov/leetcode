public class Solution {
    private ArrayList<Integer> answer;

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }

        answer.add(node.val);
        search(node.left);
        search(node.right);
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        answer = new ArrayList<Integer>();
        if (root == null) {
            return answer;
        }
        search(root);
        return answer;
    }
}