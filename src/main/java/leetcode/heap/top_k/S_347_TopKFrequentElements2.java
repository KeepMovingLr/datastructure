package leetcode.heap.top_k;

import queue.PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author enyi.lr
 * @version $Id: Solution347.java, v 0.1 2019‐05‐25 3:50 PM enyi.lr Exp $$
 * v2
 */
public class S_347_TopKFrequentElements2 {

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

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequentMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequentMap.containsKey(nums[i])) {
                Integer frequence = frequentMap.get(nums[i]);
                frequence++;
                frequentMap.put(nums[i], frequence);
            } else {
                frequentMap.put(nums[i], 1);
            }

        }

        PriorityQueue<Frequence> priorityQueue = new PriorityQueue<>();
        for (Integer integer : frequentMap.keySet()) {
            priorityQueue.enqueue(new Frequence(integer, frequentMap.get(integer)));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.dequeue().element);
        }
        return result;

    }

    public static void main(String[] args) {
        S_347_TopKFrequentElements2 solution347 = new S_347_TopKFrequentElements2();
        int[] nums = {1};
        List<Integer> list = solution347.topKFrequent(nums, 1);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}