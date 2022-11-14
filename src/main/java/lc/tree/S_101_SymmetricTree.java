package lc.tree;

import lc.assiststructure.TreeNode;

import java.util.List;

/**
 * @author enyi.lr
 * @date 2019/12/6 12:18 AM
 * @description ${DESCRIPTION}
 * v2
 */
public class S_101_SymmetricTree {

    public boolean isSymmetric2(TreeNode root) {
        int a = Integer.MAX_VALUE;
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // TODO: 2020/3/29  
    public int miniDay(int rows, int columns, List<List<Integer>> grid) {
        if (grid == null || (rows == 0 && columns ==0)){
            return 0;
        }

        return 0;
    }

    public boolean checkAllUpdated(List<List<Integer>> grid) {
        for (List<Integer> one : grid) {
            for (Integer point : one) {
                if (point == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
