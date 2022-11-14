package lc.array.twopointer;

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
    public static void main(String[] args) {
        int[] array = {1,1,1,2,2,3};
        Solution80 solution80 = new Solution80();
        int i = solution80.removeDuplicates3(array);
        System.out.println(i);
    }

    // use two pointer，make full use of sorted array 2019/11/26
    public int removeDuplicates3(int[] nums) {
        // use [0,k) save the un duplicate twice element has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkContainsLessThanTwice2(nums, k, nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // use two pointer
    public int removeDuplicates1(int[] nums) {
        // use [0,k) save the un duplicate twice element has been traversed
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkContainsLessThanTwice(nums, k, nums[i])) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * check weather the value in num[0,index) contains less than twice, note that the array is sorted
     *
     * @param nums
     * @param index
     * @param value
     * @return
     */
    private boolean checkContainsLessThanTwice2(int[] nums, int index, int value) {
        int times = 0;
        for (int i = 1; i <= 2; i++) {
            if (index - i >= 0 && value == nums[index - i]) {
                times++;
            } else {
                break;
            }
        }
        if (times <= 1) {
            return true;
        }
        return false;
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