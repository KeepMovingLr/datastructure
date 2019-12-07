package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @date 2019/12/5 11:31 PM
 * @description ${DESCRIPTION}
 * v2
 */
public class S_111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth < rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }

    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            int leftMinDepth = minDepth2(root.left);
            int rightMinDepth = minDepth2(root.right);
            if (leftMinDepth < rightMinDepth) {
                return leftMinDepth + 1;
            } else {
                return rightMinDepth + 1;
            }
        }
        if (root.left == null) {
            return minDepth2(root.right) + 1;
        } else {
            return minDepth2(root.left) + 1;
        }
    }

    public boolean isLeaf(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            return true;
        }
        return false;
    }

}
