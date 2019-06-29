package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution100.java, v 0.1 2019‐06‐29 12:34 AM enyi.lr Exp $$
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (q == null && p != null) {
            return false;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
        if (p == null && q == null) {
            return true;
        }
        return false;

    }

}