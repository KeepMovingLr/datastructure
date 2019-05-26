package leetcode.top_k;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution347.java, v 0.1 2019‐05‐25 3:50 PM enyi.lr Exp $$
 */
public class Solution347_2 {

    private class Frequence implements Comparable<Frequence> {
        int element;
        int freqence;

        public Frequence(int element, int freqence) {
            this.element = element;
            this.freqence = freqence;
        }

        @Override
        public int compareTo(Frequence another) {
            if (this.freqence > another.freqence) {
                return 1;
            } else if (this.freqence == another.freqence) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequentMap = new TreeMap<>();
        for (int num : nums) {
            if (frequentMap.containsKey(num)) {
                Integer frequence = frequentMap.get(num);
                frequence++;
                frequentMap.put(num, frequence);
            } else {
                frequentMap.put(num, 1);
            }
        }
        PriorityQueue<Frequence> priorityQueue = new PriorityQueue<>();
        Set<Integer> keySet = frequentMap.keySet();
        for (Integer key : keySet) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Frequence(key, frequentMap.get(key)));
            } else {
                Frequence smallest = priorityQueue.peek();
                if (frequentMap.get(key) > smallest.freqence) {
                    priorityQueue.remove();
                    priorityQueue.add(new Frequence(key, frequentMap.get(key)));
                }
            }
        }
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.remove().element);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution347_2 solution347_2 = new Solution347_2();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        List<Integer> list = solution347_2.topKFrequent2(nums2, 2);
        for (Integer element : list) {
            System.out.println(element);
        }

    }

}