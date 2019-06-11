package leetcode.attempted;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author enyi.lr
 * @version $Id: Solution199.java, v 0.1 2019‐06‐11 8:22 PM enyi.lr Exp $$
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        int currentLevel = 1;
        Queue<TreeNode> treeNodesQueue = new ArrayDeque<>();
        treeNodesQueue.add(root);
        while (!treeNodesQueue.isEmpty()) {
            TreeNode node = treeNodesQueue.remove();
            if (getLevel(node, root) == currentLevel) {
                result.add(node.val);
                currentLevel++;
            }
            if (node.right != null) {
                treeNodesQueue.add(node.right);
            }
            if (node.left != null) {
                treeNodesQueue.add(node.left);
            }

        }
        return result;
    }

    public int getLevel(TreeNode node, TreeNode root) {
        int level = 1;
        if (root == null) {
            return 0;
        }
        if (root.val == node.val) {
            return 1;
        }
        TreeNode current = root;
        while (contains(current.left, node) || contains(current.right, node)) {
            level++;
            if (contains(current.left, node)) {
                current = current.left;
            } else if (contains(current.right, node)) {
                current = current.right;
            }
        }
        return level;
    }

    private boolean contains(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return false;
        }
        if (node.val == root.val) {
            return true;
        }
        return contains(root.left, node) || contains(root.right, node);
    }

    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode root = new TreeNode(1);
        TreeNode L2L = new TreeNode(2);
        TreeNode L2R = new TreeNode(3);
        TreeNode L3L = new TreeNode(5);
        TreeNode L3R = new TreeNode(4);
        root.left = L2L;
        root.right = L2R;
        L2L.right = L3L;
        L2R.right = L3R;
        System.out.println("level:" + solution199.getLevel(root, root));
        System.out.println("level:" + solution199.getLevel(L2L, root));
        System.out.println("level:" + solution199.getLevel(L3L, root));
        System.out.println("level:" + solution199.getLevel(L2R, root));
        System.out.println("level:" + solution199.getLevel(L3R, root));
        List<Integer> list = solution199.rightSideView(root);
        System.out.println(list);
    }

}