package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution100.java, v 0.1 2019‐06‐29 12:34 AM enyi.lr Exp $$
 * v2
 */
public class S_100_SameTree {

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val){
            return isSameTree2(p.left,q.left) && isSameTree2(p.right,q.right);
        } else {
            return false;
        }
    }


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