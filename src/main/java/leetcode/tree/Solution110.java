package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution110.java, v 0.1 2019‐06‐29 12:40 AM enyi.lr Exp $$
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getMax(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private int getMax(int height, int height1) {
        if (height > height1) {
            return height;
        }
        return height1;
    }
}
