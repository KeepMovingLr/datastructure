package leetcode.collection;

import java.util.HashSet;

/**
 * @author enyi.lr
 * @version $Id: Solution349.java, v 0.1 2019‐05‐23 2:02 AM enyi.lr Exp $$
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] result = new int[set2.size()];
        Object[] objects = set2.toArray();
        for (int i = 0; i < objects.length; i++) {
            result[i] = (Integer) objects[i];
        }
        return result;
    }

}