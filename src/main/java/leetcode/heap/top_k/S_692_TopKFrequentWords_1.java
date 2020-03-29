package leetcode.heap.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution692.java, v 0.1 2019‐05‐26 5:15 PM enyi.lr Exp $$
 */
public class S_692_TopKFrequentWords_1 {

    private class WordFrequent implements Comparable<WordFrequent> {
        String  word;
        Integer frequence;

        public WordFrequent(String word, Integer frequence) {
            this.word = word;
            this.frequence = frequence;
        }

        @Override
        public int compareTo(WordFrequent o) {
            if (this.frequence > o.frequence) {
                return -1;
            } else if (this.frequence == o.frequence) {
                char[] chars = this.word.toCharArray();
                char[] chars1 = o.word.toCharArray();
                int smallSize = 0;
                if (chars.length > chars1.length) {
                    smallSize = chars1.length;
                } else {
                    smallSize = chars.length;
                }
                for (int i = 0; i < smallSize; i++) {
                    if (this.word.charAt(i) > o.word.charAt(i)) {
                        return 1;
                    }
                    if (this.word.charAt(i) < o.word.charAt(i)) {
                        return -1;
                    }
                }
                if (chars.length > chars1.length) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }

        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> wordFrequent = new HashMap<>();
        for (String word : words) {
            if (wordFrequent.containsKey(word)) {
                Integer count = wordFrequent.get(word);
                count++;
                wordFrequent.put(word, count);
            } else {
                wordFrequent.put(word, 1);
            }
        }

        // java's priorityQueue is a small heap
        PriorityQueue<WordFrequent> priorityQueue = new PriorityQueue<>();
        Set<String> keySet = wordFrequent.keySet();
        for (String key : keySet) {
            priorityQueue.add(new WordFrequent(key, wordFrequent.get(key)));
        }
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.remove().word);
        }
        return result;
    }

}