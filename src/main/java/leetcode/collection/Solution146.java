package leetcode.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution146.java, v 0.1 2019‐06‐24 11:52 PM enyi.lr Exp $$
 */
public class Solution146 {
    class LRUCache {
        int                             capacity = 0;
        int                             count    = 0;
        LinkedHashMap<Integer, Integer> map      = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Integer value = map.remove(key);
                map.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                count++;
                map.put(key, value);
                if (map.size() > capacity) {
                    LinkedHashMap<Integer, Integer> temp = new LinkedHashMap<>();
                    int i = 0;
                    int from = 1;
                    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                        if (i >= from) {
                            temp.put(integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
                        }
                        i++;
                    }
                    map.clear();
                    for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(1, 5);
    }
}