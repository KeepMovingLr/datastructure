package lc.tree;

import lc.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: Solution145.java, v 0.1 2019‐06‐11 12:34 PM enyi.lr Exp $$
 * v2
 */
public class S_145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;

    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}