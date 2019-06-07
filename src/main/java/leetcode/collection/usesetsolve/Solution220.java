package leetcode.collection.usesetsolve;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author enyi.lr
 * @version $Id: Solution220.java, v 0.1 2019‐06‐07 3:19 PM enyi.lr Exp $$
 */
public class Solution220 {

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (satisfied(set, nums[i], t)) {
                return true;
            }
            set.add(new Long(nums[i]));
            if (set.size() == k + 1) {
                set.remove(new Long(nums[i - k]));
            }
        }

        return false;
    }

    private boolean satisfied(TreeSet<Long> set, int value, int t) {
        Long least = new Long(value) - new Long(t);
        Long largest = new Long(value) + new Long(t);

        // judge weather set contains value that range in [least,largest]
        Long ceiling = set.ceiling(least);
        if (ceiling == null) {
            return false;
        }
        if (ceiling <= largest) {
            return true;
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (satisfiedSet(map, value, t).size() > 0) {
                Set<Integer> set = satisfiedSet(map, value, t);
                for (Integer index : set) {
                    if (distance(index, i) <= k) {
                        return true;
                    }
                }
                map.put(value, i);
            } else {
                map.put(value, i);
            }

        }
        return false;
    }

    private Set<Integer> satisfiedSet(TreeMap<Integer, Integer> map, int value, int distance) {
        Set<Integer> indexSet = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (distance <= distance(key, value)) {
                indexSet.add(map.get(key));
            }
        }
        return indexSet;
    }

    private int distance(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        int[] arr = {0, 2147483647};
        System.out.println(solution220.containsNearbyAlmostDuplicate2(arr, 1, 2147483647));
        System.out.println(Integer.MAX_VALUE);
    }

}