package lc.array.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @date 2019/10/24 11:10 PM
 * @description ${DESCRIPTION}
 * v2
 */
public class Solution75 {

    // 计数排序
    public void sortColors(int[] nums) {
        Map<Integer, Integer> fren = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = fren.getOrDefault(num, 0);
            orDefault++;
            fren.put(num, orDefault);
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            int count = fren.getOrDefault(i, 0);
            int end = j + count;
            for (int k = j; k < end; k++) {
                if (j < nums.length) {
                    nums[j] = i;
                    j++;
                }

            }
        }
    }

    // quick sort 3 ways
    public void sortColors2(int[] nums) {
        // use [0,k) reserve element which value equals 0
        // use (j,n-1] reserve element which value equals 2
        // use [k,j] reserve element which value equals 1
        int k = 0;
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[i] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, j);
                j--;
            }

        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
