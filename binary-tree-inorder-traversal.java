public class Solution {
    private ArrayList<Integer> answer;

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }

        search(node.left);
        answer.add(node.val);
        search(node.right);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<Integer>();
        search(root);
        return answer;
    }
}