package lc.heap.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution215.java, v 0.1 2019‐05‐26 6:08 PM enyi.lr Exp $$
 */
public class Solution451 {

    private class FrenquenceChar implements Comparable<FrenquenceChar> {
        private Character character;
        private Integer   frenquence;

        public FrenquenceChar(Character character, Integer frenquence) {
            this.character = character;
            this.frenquence = frenquence;
        }

        @Override
        public int compareTo(FrenquenceChar o) {
            if (this.frenquence > o.frenquence) {
                return -1;
            } else if (this.frenquence == o.frenquence) {
                return 0;
            } else {
                return 1;
            }

        }
    }

    public String frequencySort(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                Integer count = map.get(aChar);
                count++;
                map.put(aChar, count);
            } else {
                map.put(aChar, 1);
            }
        }
        PriorityQueue<FrenquenceChar> priorityQueue = new PriorityQueue<>();
        Set<Character> keySet = map.keySet();
        for (Character character : keySet) {
            priorityQueue.add(new FrenquenceChar(character, map.get(character)));
        }
        while (!priorityQueue.isEmpty()) {
            FrenquenceChar removed = priorityQueue.remove();
            for (int i = 0; i < removed.frenquence; i++) {
                stringBuilder.append(removed.character);
            }
        }
        return stringBuilder.toString();

    }

}