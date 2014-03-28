public class Solution {
    private ArrayList<Integer> answer;

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }

        search(node.left);
        search(node.right);
        answer.add(node.val);
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        answer = new ArrayList<Integer>();
        if (root == null) {
            return answer;
        }
        search(root);
        return answer;
    }
}