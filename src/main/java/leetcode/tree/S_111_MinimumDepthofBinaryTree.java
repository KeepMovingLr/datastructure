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
}
