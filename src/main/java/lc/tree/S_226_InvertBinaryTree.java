package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @date 2019/12/6 12:10 AM
 * @description ${DESCRIPTION}
 * v2
 */
public class S_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tempLeft = invertTree(root.left);
        TreeNode tempRight = invertTree(root.right);
        root.left = tempRight;
        root.right = tempLeft;
        return root;
    }
}
