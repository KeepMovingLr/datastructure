package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: S_404_SumOfLeftLeaves.java, v 0.1 2019‐12‐06 8:58 PM enyi.lr Exp $$
 */
public class S_404_SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 0;
        }
        return sumOfLeftLeavesRootNotNull(root);
    }

    public int sumOfLeftLeavesRootNotNull(TreeNode treeNode) {
        if (isLeaf(treeNode)) {
            return treeNode.val;
        }
        if (treeNode.left != null && treeNode.right != null) {
            int leftValue = sumOfLeftLeavesRootNotNull(treeNode.left);
            int rightValue = 0;
            if (isLeaf(treeNode.right)) {
                rightValue = 0;
            } else {
                rightValue = sumOfLeftLeavesRootNotNull(treeNode.right);
            }
            return rightValue + leftValue;
        }
        if (treeNode.left == null) {
            if (isLeaf(treeNode.right)) {
                return 0;
            } else {
                return sumOfLeftLeavesRootNotNull(treeNode.right);
            }
        } else {
            return sumOfLeftLeavesRootNotNull(treeNode.left);
        }
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

}