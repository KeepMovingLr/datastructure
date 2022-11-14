/*
package leetcode.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

*/
/**
 * @author enyi.lr
 * @version $Id: S_127_WordLadder.java, v 0.1 2019‐12‐18 1:06 PM enyi.lr Exp $$
 *//*

public class S_127_WordLadder_3 {

    // the method is right and time is ok
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        buildGraph(wordList, graph);
        Map<String, Boolean> visited = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair(beginWord, 1));
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> checkValue = queue.poll();
            String value = checkValue.getKey();
            int level = checkValue.getValue();
            // get all adjacent nodes
            Set<String> allAdjacentNodes = graph.getOrDefault(value, new HashSet<String>());
            for (String adjacentNode : allAdjacentNodes) {
                if (adjacentNode.equals(endWord)) {
                    return level + 1;
                }
                if (!visited.getOrDefault(adjacentNode, false)) {
                    visited.put(adjacentNode, true);
                    queue.add(new Pair<>(adjacentNode, level + 1));
                }
            }
        }
        return 0;
    }

    private void buildGraph(List<String> wordList, Map<String, Set<String>> graph) {
        int length = wordList.get(0).length();
        HashMap<String, Set<String>> allComboDict = new HashMap<String, Set<String>>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < length; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                        Set<String> transformations =
                                allComboDict.getOrDefault(newWord, new HashSet<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                Set<String> allAdjacentNodes = allComboDict.get(newWord);
                Set<String> orDefault = graph.getOrDefault(word, new HashSet<>());
                orDefault.addAll(allAdjacentNodes);
                graph.put(word, orDefault);
            }
        }
    }

    private boolean onlyHasOneDifferent(String a, String b) {
        int different = 0;
        for (int i = 0; i < a.length(); i++) {
            if (!a.substring(i, i + 1).equals(b.substring(i, i + 1))) {
                different++;
                if (different > 1) {
                    return false;
                }
            }
        }
        return different == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordListArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        // String[] wordListArray = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = new ArrayList<String>();
        for (int i = 0; i < wordListArray.length; i++) {
            wordList.add(wordListArray[i]);
        }
        S_127_WordLadder_3 wordLadder = new S_127_WordLadder_3();
        int length = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("length:" + length);
    }

}*/
