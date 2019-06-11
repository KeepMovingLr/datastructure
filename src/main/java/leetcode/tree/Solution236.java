package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution103.java, v 0.1 2019‐06‐11 10:19 AM enyi.lr Exp $$
 */
public class Solution236 {



    // recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lowestAncestor = null;
        if (contains(root, p) && contains(root, q)) {
            TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
            TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
            if (leftAncestor == null && rightAncestor == null) {
                lowestAncestor = root;
            } else if (leftAncestor == null && rightAncestor != null) {
                lowestAncestor = rightAncestor;
            } else if (leftAncestor != null && rightAncestor == null) {
                lowestAncestor = leftAncestor;
            }
        }
        return lowestAncestor;
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        } else {
            return contains(root.left, p) || contains(root.right, p);
        }
    }

}