package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution114.java, v 0.1 2019‐06‐29 1:18 AM enyi.lr Exp $$
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        flat(root);
    }

    public TreeNode flat(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode right = node.right;
            node.right = null;
            TreeNode lastLeft = getLastLeft(node);
            lastLeft.left = right;
        }
        return node;
    }

    private TreeNode getLastLeft(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}