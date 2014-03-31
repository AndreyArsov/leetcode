public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int root = preorder[0];
        int inorderRoot = 0;
        for (inorderRoot = 0; inorderRoot < inorder.length; inorderRoot++) {
            if (inorder[inorderRoot] == root) {
                break;
            }
        }

        int[] leftInOrder = new int[inorderRoot];
        for (int i = 0; i < inorderRoot; i++) {
            leftInOrder[i] = inorder[i];
        }

        int[] leftPreOrder = new int[inorderRoot];
        for (int i = 1; i <= inorderRoot; i++) {
            leftPreOrder[i-1] = preorder[i];
        }

        int rightLength = preorder.length - inorderRoot - 1;

        int[] rightInOrder = new int[rightLength];
        for (int i = 0; i < rightLength; i++) {
            rightInOrder[i] = inorder[i + inorderRoot + 1];
        }


        int[] rightPreOrder = new int[rightLength];
        for (int i = inorderRoot + 1; i < preorder.length; i++) {
            rightPreOrder[i - inorderRoot - 1] = preorder[i];
        }

        TreeNode newNode = new TreeNode(root);
        newNode.left = buildTree(leftPreOrder, leftInOrder);
        newNode.right = buildTree(rightPreOrder, rightInOrder);

        return newNode;
    }
}