package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @date 2019/12/6 12:18 AM
 * @description ${DESCRIPTION}
 * v2
 */
public class S_101_SymmetricTree {

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // TODO: 2019/12/6 need check why the anther is wrong.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }
        TreeNode invertRight = invertTree(root.right);
        TreeNode left = root.left;
        return isSame(invertRight, left);
    }

    public boolean isSame(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val == treeNode2.val) {
            return isSame(treeNode1.left, treeNode2.right);
        } else {
            return false;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempLeft = invertTree(root.left);
        TreeNode tempRight = invertTree(root.right);
        root.left = tempRight;
        root.right = tempLeft;
        return root;
    }
}
