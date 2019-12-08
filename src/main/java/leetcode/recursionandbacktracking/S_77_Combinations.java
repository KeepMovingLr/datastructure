package leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_77_Combinations.java, v 0.1 2019‐12‐07 8:14 PM enyi.lr Exp $$
 */
public class S_77_Combinations {

    public static void main(String[] args) {
        S_77_Combinations combinations = new S_77_Combinations();
        System.out.println(combinations.combine(4, 2));
    }

    // Time Limit Exceeded
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<List<Integer>> lists = combineList(list, k);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> oneRes : lists) {
            Collections.sort(oneRes);
            if (!result.contains(oneRes)) {
                result.add(oneRes);
            }
        }
        return result;
    }

    public List<List<Integer>> combineList(List<Integer> list, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > list.size()) {
            return result;
        }
        if (k == list.size()) {
            result.add(list);
            return result;
        }
        if (k == 1) {
            for (Integer num : list) {
                List<Integer> oneRes = new ArrayList<>();
                oneRes.add(num);
                result.add(oneRes);
            }
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            int selected = list.get(i);
            List<Integer> left = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j != i) {
                    left.add(list.get(j));
                }
            }
            List<List<Integer>> lists = combineList(left, k - 1);
            for (List<Integer> res : lists) {
                res.add(selected);
            }
            result.addAll(lists);
        }
        return result;
    }

}