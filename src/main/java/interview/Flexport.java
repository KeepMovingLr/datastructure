package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author enyi.lr
 * @version $Id: Solution.java, v 0.1 2019‐12‐13 9:13 AM enyi.lr Exp $$
 */
public class Flexport {

    /*
      public String selectWords2(int num, int selectedCount, String sentence) {
        if (selectedCount > num || num == 0 || sentence == null || selectedCount == 0) {
            return "";
        }
        String[] selectedWords = new String[selectedCount];
        String[] words = sentence.split(" ");
        int length = words.length;
        int random = getRandoNum(length);
        // 初始化selectedWords
        selectedWords[0] = words[random];
        for (int i = 1; i < selectedCount; i++) {
            selectedWords[i] = words[(random + 1) % selectedCount];
        }

    }*/

    public String selectWords(int num, String sentence) {
        if (num == 0 || sentence == null) {
            return "";
        }
        String[] words = sentence.split(" ");
        int length = words.length;
        int random = getRandoNum(length);
        StringBuilder resultBuilder = new StringBuilder();
        String randomNext = words[random];
        resultBuilder.append(randomNext).append(" ");
        for (int i = 1; i < num; i++) {
            // get random next
            randomNext = getRandomNext(randomNext, words);
            resultBuilder.append(randomNext).append(" ");
        }
        String result = resultBuilder.toString();
        return result.substring(0, result.length() - 1);
    }

    private String getRandomNext(String selectedWord, String[] words) {
        List<Integer> current = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (selectedWord.equals(words[i])) {
                current.add(i);
                next.add((i + 1) % words.length);
            }
        }
        int randomNum = getRandoNum(next.size());
        return words[next.get(randomNum)];
    }

    private int getRandoNum(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }

    public static void main(String[] args) {
        Flexport solution = new Flexport();
        String sentence = "this is a sentence it is not a good one and it is also not bad";
        System.out.println(solution.selectWords(3,sentence));

    }
}