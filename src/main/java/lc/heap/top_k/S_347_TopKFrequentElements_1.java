package lc.heap.top_k;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution347.java, v 0.1 2019‐05‐25 3:50 PM enyi.lr Exp $$
 */
public class S_347_TopKFrequentElements_1 {

    private class Frequency implements Comparable<Frequency> {
        int element;
        int freqency;

        public Frequency(int element, int freqence) {
            this.element = element;
            this.freqency = freqence;
        }

        @Override
        public int compareTo(Frequency another) {
            if (this.freqency > another.freqency) {
                return 1;
            } else if (this.freqency == another.freqency) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequentMap.containsKey(nums[i])) {
                Integer frequency = frequentMap.get(nums[i]);
                frequency++;
                frequentMap.put(nums[i], frequency);
            } else {
                frequentMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Frequency> priorityQueue = new PriorityQueue<>();
        for (Integer key : frequentMap.keySet()) {
            priorityQueue.add(new Frequency(key, frequentMap.get(key)));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.remove().element);
        }
        return result;

    }

}