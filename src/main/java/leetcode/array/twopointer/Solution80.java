package leetcode.array.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution80.java, v 0.1 2019‐05‐19 10:47 PM enyi.lr Exp $$
 * v2
 */
public class Solution80 {

    // use two pointer
    public int removeDuplicates1(int[] nums) {
        // use [0,k) save the un duplicate twice element has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!checkContainsLessThanTwice(nums, k, nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * check weather the value in num[0,index) contains less than twice
     *
     * @param nums
     * @param index
     * @param value
     * @return
     */
    private boolean checkContainsLessThanTwice(int[] nums, int index, int value) {
        int times = 0;
        for (int i = 0; i < index; i++) {
            if (value == nums[i]) {
                times++;
            }
        }
        if (times <= 1) {
            return true;
        }
        return false;
    }

    //  use map
    public int removeDuplicates2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
                resultList.add(num);
            } else {
                if (countMap.get(num) != 2) {
                    countMap.put(num, 2);
                    resultList.add(num);
                }
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            nums[i] = resultList.get(i);
        }
        return resultList.size();

    }

}