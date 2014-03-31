public class Solution {
    ArrayList<Integer> list2;
    ArrayList<TreeNode> list3;

    private void search(TreeNode node) {
        if (node == null) {
            return;
        }

        search(node.left);
        list2.add(node.val);
        list3.add(node);
        search(node.right);
    }

    public void recoverTree(TreeNode root) {
        list2 = new ArrayList<Integer>();
        list3 = new ArrayList<TreeNode>();

        search(root);
        Collections.sort(list2);

        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i) != list3.get(i).val) {
                if (p1 == -1) {
                    p1 = i;
                } else {
                    p2 = i;
                }
            }
        }

        int t = list3.get(p1).val;
        list3.get(p1).val = list3.get(p2).val;
        list3.get(p2).val = t;
    }
}