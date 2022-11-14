package lc.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution75.java, v 0.1 2019‐05‐20 11:34 PM enyi.lr Exp $$
 *  similar  75，88，215
 *  similar  26，27，80，283
 */
public class Solution75 {

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution75.sortColors3(nums);
        System.out.println(nums);
    }

    public void sortColors3(int[] nums) {
        // use [0,k) save 0 element
        int k = 0;
        // use(j,n-1] save 2 element
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[i] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
                i++;
                continue;
            }
            if (nums[i] == 2) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
            if (nums[i] == 1) {
                i++;
            }
        }
    }

    // 计数排序法
    public void sortColors2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.get(num) == null) {
                countMap.put(num, 1);
            } else {
                Integer count = countMap.get(num);
                count++;
                countMap.put(num, count);
            }
        }
        int zeroNum = 0;
        int oneNum = 0;
        int twoNum = 0;
        if (countMap.get(0) != null) {
            zeroNum = countMap.get(0);
        }
        if (countMap.get(1) != null) {
            oneNum = countMap.get(1);
        }
        if (countMap.get(2) != null) {
            twoNum = countMap.get(2);
        }
        for (int i = 0; i < zeroNum; i++) {
            nums[i] = 0;
        }
        for (int i = zeroNum; i < zeroNum + oneNum; i++) {
            nums[i] = 1;
        }
        for (int i = (zeroNum + oneNum); i < zeroNum + oneNum + twoNum; i++) {
            nums[i] = 2;
        }
    }

    public void sortColors1(int[] nums) {

        List<Integer> lists = new ArrayList<>();
        for (int num : nums) {
            lists.add(num);
        }
        int i = 0;
        Collections.sort(lists);
        for (Integer integer : lists) {
            nums[i] = integer;
            i++;
        }

    }

}