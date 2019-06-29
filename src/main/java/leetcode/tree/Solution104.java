package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution104.java, v 0.1 2019‐06‐28 11:56 PM enyi.lr Exp $$
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int max = getMax(leftDepth, rightDepth);
        return max + 1;
    }

    private int getMax(int leftDepth, int rightDepth) {
        if (leftDepth > rightDepth) {
            return leftDepth;
        } else {
            return rightDepth;
        }
    }

}