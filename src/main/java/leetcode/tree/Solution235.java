package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution235.java, v 0.1 2019‐06‐11 10:51 AM enyi.lr Exp $$
 */
public class Solution235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        if (contains(root, p) && contains(root, q)) {
            if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
                ancestor = root;
            } else if (p.val < root.val && q.val < root.val) {
                ancestor = lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                ancestor = lowestCommonAncestor(root.right, p, q);
            }
        }
        return ancestor;
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        } else if (p.val < root.val) {
            return contains(root.left, p);
        } else {
            return contains(root.right, p);
        }
    }

}