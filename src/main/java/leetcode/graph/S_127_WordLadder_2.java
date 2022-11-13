/*
package leetcode.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

*/
/**
 * @author enyi.lr
 * @version $Id: S_127_WordLadder.java, v 0.1 2019‐12‐18 1:06 PM enyi.lr Exp $$
 *//*

public class S_127_WordLadder_2 {

    // the method is right, but time limit exceed
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
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
            List<String> allAdjacentNodes = graph.getOrDefault(value, new ArrayList<>());
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

    // todo how to optimize the process of building the graph
    private void buildGraph(List<String> wordList, Map<String, List<String>> graph) {
        // the code here costs much time
        for (int i = 0; i < wordList.size(); i++) {
            String checkedWord = wordList.get(i);
            List<String> adjacentNodes = graph.getOrDefault(checkedWord, new ArrayList<>());
            graph.put(checkedWord, adjacentNodes);
            for (int j = i + 1; j < wordList.size(); j++) {
                String compared = wordList.get(j);
                if (!adjacentNodes.contains(compared)) {
                    if (onlyHasOneDifferent(checkedWord, compared)) {
                        adjacentNodes.add(compared);
                        List<String> orDefault = graph.getOrDefault(compared, new ArrayList<>());
                        orDefault.add(checkedWord);
                        graph.put(compared, orDefault);
                    }
                }
            }
        }
    }

    private void buildGraph2(List<String> wordList, Map<String, List<String>> graph) {
        int length = wordList.get(0).length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < length; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                ArrayList<String> allAdjacentNodes = allComboDict.get(newWord);



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
        // String[] wordListArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] wordListArray = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = new ArrayList<String>();
        for (int i = 0; i < wordListArray.length; i++) {
            wordList.add(wordListArray[i]);
        }
        S_127_WordLadder_2 wordLadder = new S_127_WordLadder_2();
        int length = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("length:" + length);
    }

}*/
