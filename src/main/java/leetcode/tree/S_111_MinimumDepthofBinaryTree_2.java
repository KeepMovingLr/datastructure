package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @date 2019/12/5 11:31 PM
 * @description ${DESCRIPTION} v2
 */
public class S_111_MinimumDepthofBinaryTree_2 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepthWithNotNullNode(root);
    }

    /**
     * recursive method. treeNode should not be null. So, we should not pass a null value to the method.
     *
     * @param treeNode is a element which is not NULL.
     * @return
     */
    public int minDepthWithNotNullNode(TreeNode treeNode) {
        // 递归终止条件
        if (isLeaf(treeNode)) {
            return 1;
        }
        if (treeNode.left != null && treeNode.right != null) {
            int leftMinDepth = minDepthWithNotNullNode(treeNode.left);
            int rightMinDepth = minDepthWithNotNullNode(treeNode.right);
            if (leftMinDepth < rightMinDepth) {
                return leftMinDepth + 1;
            } else {
                return rightMinDepth + 1;
            }
        }
        if (treeNode.left == null) {
            return minDepthWithNotNullNode(treeNode.right) + 1;
        } else {
            return minDepthWithNotNullNode(treeNode.left) + 1;
        }
    }

    public boolean isLeaf(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            return true;
        } else {
            return false;
        }

    }

}
