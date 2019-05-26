package leetcode.top_k;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution414 {

    public int thirdMax(int[] nums) {
        //remove duplication
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return nums[0];
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer num : set) {
            if (priorityQueue.size() < 3) {
                priorityQueue.add(num);
            } else {
                if (num > priorityQueue.peek()) {
                    priorityQueue.remove();
                    priorityQueue.add(num);
                }
            }
        }
        if (priorityQueue.size() == 3) {
            return priorityQueue.peek();
        } else {
            int result = priorityQueue.remove();
            while (!priorityQueue.isEmpty()) {
                result = priorityQueue.remove();
            }
            return result;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(1);
        System.out.println(priorityQueue.size());
    }

}