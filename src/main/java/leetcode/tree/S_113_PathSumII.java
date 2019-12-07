package leetcode.tree;

import leetcode.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_113_PathSumII.java, v 0.1 2019‐12‐07 11:39 AM enyi.lr Exp $$
 */
public class S_113_PathSumII {

    // First, find all paths then filter the unsatisfied paths.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> allPath = getAllPath(root);
        for (List<Integer> list : allPath) {
            int pathSum = 0;
            for (Integer val : list) {
                pathSum = pathSum+val;
            }
            if (pathSum == sum){
                Collections.reverse(list);
                result.add(list);
            }
        }
        return result;
    }

    // find all path
    public List<List<Integer>> getAllPath(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (isLeaf(node)) {
            List<Integer> onePath = new ArrayList<>();
            onePath.add(node.val);
            result.add(onePath);
            return result;
        }
        if (node.left != null && node.right != null) {
            List<List<Integer>> allLeftPath = getAllPath(node.left);
            List<List<Integer>> allRightPath = getAllPath(node.right);
            // add the node value
            for (List<Integer> list : allLeftPath) {
                list.add(node.val);
            }
            for (List<Integer> list : allRightPath) {
                list.add(node.val);
            }
            result.addAll(allLeftPath);
            result.addAll(allRightPath);
            return result;
        }
        if (node.left == null){
            List<List<Integer>> allRightPath = getAllPath(node.right);
            for (List<Integer> list : allRightPath) {
                list.add(node.val);
            }
            result.addAll(allRightPath);
        } else {
            List<List<Integer>> allLeftPath = getAllPath(node.left);
            for (List<Integer> list : allLeftPath) {
                list.add(node.val);
            }
            result.addAll(allLeftPath);
        }
        return result;
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}