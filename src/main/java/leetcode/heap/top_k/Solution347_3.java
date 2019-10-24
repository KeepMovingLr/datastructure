package leetcode.heap.top_k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solutio347_3.java, v 0.1 2019‐10‐24 1:08 PM enyi.lr Exp $$ v2
 */
public class Solution347_3 {

    class Frequency {
        int element;
        int frequencys;

        public Frequency(int element, int frequencys) {
            this.element = element;
            this.frequencys = frequencys;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = frequency.getOrDefault(num, 0);
            orDefault++;
            frequency.put(num, orDefault);
        }

        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if (o1.frequencys > o2.frequencys) {
                    return 1;
                } else if (o1.frequencys < o2.frequencys) {
                    return -1;
                }
                return 0;
            }
        });

        for (Integer key : frequency.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Frequency(key, frequency.get(key)));
            } else {
                if (frequency.get(key) > priorityQueue.peek().frequencys) {
                    priorityQueue.remove();
                    priorityQueue.add(new Frequency(key, frequency.get(key)));
                }
            }

        }
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove().element);
        }
        return result;

    }

}