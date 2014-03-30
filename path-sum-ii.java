public class Solution {
    private int sum;
    private ArrayList<ArrayList<Integer>> answer;

    private void search(TreeNode node, int currentSum, ArrayList<TreeNode> nodes) {
        if (node.left == null && node.right == null) {
            if (currentSum == this.sum) {
                ArrayList<Integer> path = new ArrayList<Integer>();
                for (TreeNode n : nodes) {
                    path.add(n.val);
                }
                answer.add(path);
            }
        }

        if (node.left != null) {
            nodes.add(node.left);
            search(node.left, currentSum + node.left.val, nodes);
            nodes.remove(nodes.size() - 1);
        }

        if (node.right != null) {
            nodes.add(node.right);
            search(node.right, currentSum + node.right.val, nodes);
            nodes.remove(nodes.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        answer = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return answer;
        }

        this.sum = sum;
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        search(root, root.val, nodes);
        return answer;
    }
}