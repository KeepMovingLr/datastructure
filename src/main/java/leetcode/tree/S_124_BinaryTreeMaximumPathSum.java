package leetcode.tree;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution124.java, v 0.1 2019‐06‐11 9:36 PM enyi.lr Exp $$
 */
public class S_124_BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrderTravel(root, list);
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    private void inOrderTravel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.left, list);
        list.add(max(node));
        inOrderTravel(node.right, list);
    }

    private int max(TreeNode node) {
        int max = node.val;
        if (maxPathOfNode(node.left) > 0) {
            max = max + maxPathOfNode(node.left);
        }
        if (maxPathOfNode(node.right) > 0) {
            max = max + maxPathOfNode(node.right);
        }
        return max;
    }

    // max path contain the root node of the tree
    private int maxPathOfNode(TreeNode root) {
        if (root != null) {
            int max = root.val;
            if (root.left != null) {
                int sum2 = maxPathOfNode(root.left) + root.val;
                max = Math.max(max, sum2);
            }
            if (root.right != null) {
                int sum4 = maxPathOfNode(root.right) + root.val;
                max = Math.max(max, sum4);
            }
            return max;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        TreeNode l1l = new TreeNode(-2);
        TreeNode l1r = new TreeNode(-3);
        root.left = l1l;
        root.right = l1r;
        TreeNode l2ll = new TreeNode(1);
        TreeNode l2lr = new TreeNode(3);
        l1l.left = l2ll;
        l1l.right = l2lr;
        TreeNode l2rl = new TreeNode(-2);
        l1r.left = l2rl;
        TreeNode l3 = new TreeNode(-1);
        l2ll.left = l3;

        */
        TreeNode root = new TreeNode(2);
        TreeNode l = new TreeNode(-1);
        TreeNode r = new TreeNode(-2);
        root.left = l;
        root.right = r;
        S_124_BinaryTreeMaximumPathSum solution124 = new S_124_BinaryTreeMaximumPathSum();
        int i = solution124.maxPathSum(root);
        System.out.println("max:" + i);

    }
}