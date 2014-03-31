public class Solution {
    private TreeNode search(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        } else if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int root = postorder[postEnd];
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                break;
            }
        }

        TreeNode newNode = new TreeNode(root);
        newNode.left = search(inorder, postorder, inStart, i - 1, postStart, postStart + (i - inStart - 1));
        newNode.right = search(inorder, postorder, i + 1, inEnd, postStart + (i - inStart), postEnd - 1);

        return newNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        return search(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}
