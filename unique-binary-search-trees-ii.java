public class Solution {
    private ArrayList<TreeNode> search(int lower, int upper) {
        if (lower > upper) {
            ArrayList<TreeNode> empty = new ArrayList<TreeNode>();
            empty.add(null);
            return empty;
        }

        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();

        for (int root = lower; root <= upper; root++) {
            ArrayList<TreeNode> lefts = search(lower, root - 1);
            ArrayList<TreeNode> rights = search(root + 1, upper);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode newRoot = new TreeNode(root);
                    newRoot.left = left;
                    newRoot.right = right;
                    trees.add(newRoot);
                }
            }
        }

        return trees;
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return search(1, n);
    }
}