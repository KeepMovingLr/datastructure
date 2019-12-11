package leetcode.tree;

import leetcode.assiststructure.TreeNode;

/**
 * @author enyi.lr
 * @version $Id: S_450_DeleteNodeInABST.java, v 0.1 2019‐12‐07 2:34 PM enyi.lr Exp $$
 */
public class S_450_DeleteNodeInABST {

    // TODO: 2019/12/7
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            return deleteRoot(root);
        }
        if (key < root.val && root.left != null) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val && root.right != null) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    /**
     * delete the root of the tree and return the new root
     *
     * @param root
     * @return
     */
    public TreeNode deleteRoot(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            TreeNode newRoot = getTheLargestNode(root.left);
            TreeNode node = removeTheLargestNode(root.left);
            newRoot.left = node.left;
            newRoot.right = node.right;
            node.left = null;
            node.right = null;
            return newRoot;
        }
        if (root.left == null) {
            TreeNode newRoot = root.right;
            root.right = null;
            return newRoot;
        } else {
            TreeNode newRoot = root.left;
            root.left = null;
            return newRoot;
        }
    }

    public TreeNode getTheLargestNode(TreeNode root) {
        TreeNode largestOne = root;
        if (largestOne.right != null) {
            return getTheLargestNode(largestOne.right);
        } else {
            return largestOne;
        }
    }

    /**
     * remove the largest node of the tree，and return the new root
     *
     * @param currentRoot
     * @return
     */
    private TreeNode removeTheLargestNode(TreeNode currentRoot) {
        if (currentRoot.right == null) {
            TreeNode leftNode = currentRoot.left;
            currentRoot.left = null;
            return leftNode;
        }
        currentRoot.right = removeTheLargestNode(currentRoot.right);
        return currentRoot;
    }

}