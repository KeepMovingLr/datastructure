package leetcode.tree;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution94.java, v 0.1 2019‐06‐11 12:23 PM enyi.lr Exp $$
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}