package lc.tree;

import lc.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: Solution235.java, v 0.1 2019‐06‐11 10:51 AM enyi.lr Exp $$
 * v2
 */
public class S_235_LowestCommonAncestorOfABinarySearchTree_2 {

    // 没有S_235_LowestCommonAncestorOfABinarySearchTree中的方法好，每一充分利用二分搜索树的条件
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        if (root == null){
            return null;
        }
        if (contains(root, p) && contains(root, q)) {
            result = root;
        }
        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);
        if (leftTreeNode != null){
            result = leftTreeNode;
        }
        if (rightTreeNode != null){
            result = rightTreeNode;
        }
        return result;
    }

    /**
     * check the tree which root is currentRoot contains the checkedNode
     *
     * @param currentRoot
     * @param checkedNode
     * @return
     */
    public boolean contains(TreeNode currentRoot, TreeNode checkedNode) {
        if (currentRoot == null) {
            return false;
        }
        if (currentRoot.val == checkedNode.val) {
            return true;
        } else {
            return contains(currentRoot.left, checkedNode) || contains(currentRoot.right, checkedNode);
        }
    }

}