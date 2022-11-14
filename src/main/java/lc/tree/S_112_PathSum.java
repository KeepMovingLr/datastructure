package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: S_112_PathSum.java, v 0.1 2019‐12‐06 1:48 PM enyi.lr Exp $$
 */
public class S_112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (isLeaf(root)) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // second method
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumNotRoot(root, sum);
    }

    public boolean hasPathSumNotRoot(TreeNode treeNode, int sum) {
        if (isLeaf(treeNode)) {
            return treeNode.val == sum;
        }
        if (treeNode.left == null) {
            return hasPathSumNotRoot(treeNode.right, sum - treeNode.val);
        }
        if (treeNode.right == null) {
            return hasPathSumNotRoot(treeNode.left, sum - treeNode.val);
        }
        return hasPathSumNotRoot(treeNode.left, sum - treeNode.val) || hasPathSumNotRoot(treeNode.right, sum - treeNode.val);

    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

}