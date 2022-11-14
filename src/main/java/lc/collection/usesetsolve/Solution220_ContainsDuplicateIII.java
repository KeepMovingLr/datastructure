package lc.collection.usesetsolve;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author enyi.lr
 * @version $Id: Solution220.java, v 0.1 2019‐06‐07 3:19 PM enyi.lr Exp $$
 * v2
 */
public class Solution220_ContainsDuplicateIII {

    public static void main(String[] args) {
        Solution220_ContainsDuplicateIII solution220 = new Solution220_ContainsDuplicateIII();
        int[] arr = {1, 2, 3, 1};
        System.out.println(solution220.containsNearbyAlmostDuplicate4(arr, 3, 0));
        System.out.println(Integer.MAX_VALUE);
    }

    //
    public boolean containsNearbyAlmostDuplicate4(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // satisfied();
            if (satisfied2(set, num, t)) {
                return true;
            } else {
                set.add((long) num);
            }
            if (set.size() >= k + 1) {
                set.remove(new Long(nums[i - k]));
            }
        }
        return false;
    }

    // force
    // time complexity O(n^2)  n squared
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                if (distance2(a,b) <= t && distance2(i,j) <= k){
                    return true;
                }
            }
        }
        return false;
    }

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

    private boolean satisfied2(TreeSet<Long> set, int value, int t) {
        if (set.isEmpty()){
            return false;
        }
        // floor--value--ceiling
        Long ceiling = set.ceiling((long) value);
        Long floor = set.floor((long) value);
        if (floor == null) {
            if (ceiling-value <= t){
                return true;
            } else {
                return false;
            }
        }
        if (ceiling == null){
            if (value-floor <= t){
                return true;
            } else {
                return false;
            }
        }
        if (floor != null && ceiling != null){
            if (ceiling - value <=t || value-floor <=t){
                return true;
            }
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

    private long distance2(long a, long b) {
        return Math.abs(a - b);
    }



}