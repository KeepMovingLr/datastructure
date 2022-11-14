package lc.heap.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author enyi.lr
 * @version $Id: Solution692.java, v 0.1 2019‐05‐26 5:15 PM enyi.lr Exp $$
 */
public class S_692_TopKFrequentWords_2 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> maps = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = maps.getOrDefault(word, 0);
            count++;
            maps.put(word, count);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (maps.get(a) - maps.get(b) > 0) {
                    return 1;
                } else if (maps.get(a) - maps.get(b) < 0) {
                    return -1;
                } else {
                    return b.compareTo(a);
                }

            }
        });

        for (String key : maps.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        List<String> topK = new ArrayList<String>();
        while (!queue.isEmpty()) {
            topK.add(queue.remove());
        }
        Collections.reverse(topK);
        return topK;

    }

}