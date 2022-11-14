package lc.heap.top_k;

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
public class S_347_TopKFrequentElements_4 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }

        });
        for (Integer key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }
}