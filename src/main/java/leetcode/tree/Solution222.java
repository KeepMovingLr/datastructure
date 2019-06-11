package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution222.java, v 0.1 2019‐06‐11 8:15 PM enyi.lr Exp $$
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


}