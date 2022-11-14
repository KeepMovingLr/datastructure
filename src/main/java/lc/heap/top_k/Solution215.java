package lc.heap.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 * v2
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest1(nums, k);
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (num > priorityQueue.peek()) {
                    priorityQueue.remove();
                    priorityQueue.add(num);
                }
            }
        }
        return priorityQueue.remove();
    }

    // v2 2019‐10‐24
    public int findKthLargest4(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num){
                    priorityQueue.remove();
                    priorityQueue.add(num);
                }
            }
        }
        return priorityQueue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a.intValue() > b.intValue()) {
                    return -1;
                } else if (a.intValue() == b.intValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (int num : nums) {
            priorityQueue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.remove();
        }
        return priorityQueue.peek();
    }

    public int findKthLargest1(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        Integer integer = list.get(nums.length - k);
        return integer;
    }

}