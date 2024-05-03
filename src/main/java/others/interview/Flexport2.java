package others.interview;

import java.util.*;

/**
 * Generate a random sentence of length N from a given text. Logic:
 * 1. Randomly select a word
 * 2. The next word will be the subsequent contagious word from the previously selected word. If the next word occurs multiple times in the sentence, select randomly.
 * 3. Continue until length fulfill required length
 * Special case: If the chosen word has no next word (last word in the sentence, use first word as the "next word" - assume circular)
 * Example
 * text = "hello this is a flexport interview and this is a hello and that was cool"
 * n = 4
 * • say first word randomly selected is "flexport"
 * • next word after "flexport" in the text is "interview". "interview" onlv occurs once.
 * • next word after "interview" in the text is "and". "and" occurs twice at index 6 & 11. Randomly select one of the indices. Say we select the one at index 6
 * • next word after "and" at index 6 is "this". "this" occurs at twice at index 1 & 7. Randomlv selected at 7.
 * Outout: "flexport interview and this"
 */
public class Flexport2 {
    String[] words;
    Map<String , List<Integer>> wordIdx = new HashMap<>();
    int idx;
    public String randomSelect(int n , String sentence) {
        words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(!wordIdx.containsKey(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                wordIdx.put(words[i] , list);
            } else {
                List<Integer> list = wordIdx.get(words[i]);
                list.add(i);
                wordIdx.put(words[i] , list);
            }
        }
        StringBuilder sb = new StringBuilder();
        // get the first random
        idx = getRandoNum(words.length);
        sb.append(words[idx]);
        sb.append(" ");
        if(n == 1)
            return sb.toString();
        for(int i = 1 ; i < n ; i++) {
            if(idx == words.length - 1) {
                idx = 0;
            } else {
                idx = idx + 1;
            }
            sb.append(select());
            sb.append(" ");
        }
        return sb.toString();
    }

    private int getRandoNum(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }

    public String select() {
        String word = words[idx];
        List<Integer> list = wordIdx.get(word);
        if(list.size() == 1) {
            return word;
        } else {
            int listIdx = getRandoNum(list.size());
            idx = list.get(listIdx);
            return word;
        }
    }

    public static void main(String[] args) {
        Flexport2 flexport = new Flexport2();
        String s = flexport.randomSelect(4, "hello this is a flexport interview and this is a hello and that was cool");
        System.out.println(s);
    }
}
