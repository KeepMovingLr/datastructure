package lc.tree;

import lc.assiststructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_129_SumRoottoLeafNumbers.java, v 0.1 2019‐12‐07 11:42 AM enyi.lr Exp $$
 */
public class S_129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        List<List<Integer>> allPath = getAllPath(root);
        for (List<Integer> list : allPath) {
            double eachSum = 0;
            int i = 0;
            for (Integer val : list) {
                eachSum = eachSum + val * Math.pow(10, i);
                i++;
            }
            sum = sum + (int) eachSum;
        }
        return sum;
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
        if (node.left == null) {
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