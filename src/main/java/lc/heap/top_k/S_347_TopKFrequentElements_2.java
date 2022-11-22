package lc.heap.top_k;

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
public class S_347_TopKFrequentElements_2 {

    private class Frequency implements Comparable<Frequency> {
        int element;
        int frequency;

        public Frequency(int element, int freqence) {
            this.element = element;
            this.frequency = freqence;
        }

        @Override
        public int compareTo(Frequency another) {
            if (this.frequency > another.frequency) {
                return 1;
            } else if (this.frequency == another.frequency) {
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
                Integer frequency = frequentMap.get(num);
                frequency++;
                frequentMap.put(num, frequency);
            } else {
                frequentMap.put(num, 1);
            }
        }
        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>();
        Set<Integer> keySet = frequentMap.keySet();
        for (Integer key : keySet) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Frequency(key, frequentMap.get(key)));
            } else {
                Frequency smallest = priorityQueue.peek();
                if (frequentMap.get(key) > smallest.frequency) {
                    priorityQueue.remove();
                    priorityQueue.add(new Frequency(key, frequentMap.get(key)));
                }
            }
        }
        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.remove().element);
        }
        return result;
    }

    public static void main(String[] args) {
        S_347_TopKFrequentElements_2 solution347_2 = new S_347_TopKFrequentElements_2();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        List<Integer> list = solution347_2.topKFrequent2(nums2, 2);
        for (Integer element : list) {
            System.out.println(element);
        }

    }

}