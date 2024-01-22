package others.wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author enyi.lr
 * @version $Id: WordCounter.java, v 0.1 2019‐07‐02 5:10 PM enyi.lr Exp $$
 */
public class WordCounter {

    private File file;

    public WordCounter(String path) {
        File file = new File(path);
        this.file = file;
    }

    public int countWord() {
        Map<String, Integer> counter = new HashMap<>();
        BufferedReader bufferedReader = null;
        boolean needAdd = true;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                for (String s : split) {
                    needAdd = true;
                    if (!"".equals(s) && !" ".equals(s)) {
                        s = s.replace(",", "");
                        s = s.replace(".", "");
                        s = s.replace("(", "");
                        s = s.replace(")", "");
                        for (int i = 0; i < s.length(); i++) {
                            if (!Character.isAlphabetic(s.charAt(i))) {
                                needAdd = false;
                                break;
                            }
                        }
                        if (needAdd) {
                            Integer count = counter.getOrDefault(s.toLowerCase(), 0);
                            count++;
                            counter.put(s.toLowerCase(), count);
                        }

                    }
                }
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Map<String, Integer> sortedByCount = counter.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 > o2) {
                            return -1;
                        } else if (o1 < o2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedByCount.size();
    }



    public static void main(String[] args) {
        WordCounter counter = new WordCounter("/Users/juju/github/datastructure/src/main/java/wordcounter/needcount.txt");
        int result = counter.countWord();
        System.out.println("total count without duplicate:" + result);

    }

}