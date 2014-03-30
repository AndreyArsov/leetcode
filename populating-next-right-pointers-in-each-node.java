public  class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        ArrayList<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
        queue.add(root);

        while (queue.size() > 0) {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.get(i).next = queue.get(i + 1);
            }
            queue.get(queue.size() - 1).next = null;

            ArrayList<TreeLinkNode> nextLayer = new ArrayList<TreeLinkNode>();
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).left != null) {
                    nextLayer.add(queue.get(i).left);
                }

                if (queue.get(i).right != null) {
                    nextLayer.add(queue.get(i).right);
                }
            }

            queue = nextLayer;
        }
    }
}