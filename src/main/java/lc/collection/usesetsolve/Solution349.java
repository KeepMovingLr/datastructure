package lc.collection.usesetsolve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author enyi.lr
 * @version $Id: Solution349.java, v 0.1 2019‐05‐23 2:02 AM enyi.lr Exp $$
 * v2 2019‐10‐23
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

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)){
                list.add(integer);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }



}