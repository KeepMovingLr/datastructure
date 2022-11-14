package lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_77_Combinations.java, v 0.1 2019‐12‐07 8:14 PM enyi.lr Exp $$
 */
public class S_77_Combinations_3 {

    public static void main(String[] args) {
        S_77_Combinations_3 combinations = new S_77_Combinations_3();
        System.out.println(combinations.combine(4, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return combineList(list, k);
    }

    // 先比上一版解法，增加了减枝操作
    public List<List<Integer>> combineList(List<Integer> list, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }
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
        // list.size() >= k 减枝操作
        while (!list.isEmpty() && list.size() >= k) {
            int selected = list.remove(0);
            int selectCount = k;
            List<Integer> list2 = new ArrayList<>();
            for (Integer num : list) {
                list2.add(num);
            }
            selectCount--;
            List<List<Integer>> lists = combineList(list2, selectCount);
            for (List<Integer> res : lists) {
                res.add(selected);
            }
            result.addAll(lists);
        }
        return result;
    }

}