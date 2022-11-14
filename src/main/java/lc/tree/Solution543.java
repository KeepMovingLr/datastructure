package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution543.java, v 0.1 2019‐06‐11 7:36 PM enyi.lr Exp $$
 */
public class Solution543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMaxDiameter(root);
    }

    public int getMaxDiameter(TreeNode node) {
        int rootC = getHeight(node.left) + getHeight(node.right);
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = getMaxDiameter(node.left);
        }
        if (node.right != null) {
            right = getMaxDiameter(node.right);
        }
        return Math.max(Math.max(rootC, left), right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}