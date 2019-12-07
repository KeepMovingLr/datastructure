package leetcode.tree;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_230_KthSmallestElementInABST.java, v 0.1 2019‐12‐07 2:25 PM enyi.lr Exp $$ v2
 */
public class S_230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list.get(k-1);
    }

    // inorder the tree get the sorted array
    public void inOrderTraversal(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.left, result);
        result.add(treeNode.val);
        inOrderTraversal(treeNode.right, result);
    }

}