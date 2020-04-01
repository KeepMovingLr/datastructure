package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: S_126_WordLadderII.java, v 0.1 2019‐12‐19 1:04 PM enyi.lr Exp $$
 */
public class S_126_WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordListArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<String>();
        for (int i = 0; i < wordListArray.length; i++) {
            wordList.add(wordListArray[i]);
        }
        S_126_WordLadderII s_126_wordLadderII = new S_126_WordLadderII();
        List<List<String>> ladders = s_126_wordLadderII.findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);

    }

    // Time Limit Exceeded
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        buildGraph(wordList, graph);
        Map<String, Boolean> visited = new HashMap<>();
        List<List<String>> shortestLadder = getAllPaths(beginWord, endWord, graph, visited);
        int minSize = Integer.MAX_VALUE;
        for (List<String> list : shortestLadder) {
            if (list.size() < minSize) {
                minSize = list.size();
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : shortestLadder) {
            if (list.size() == minSize) {
                Collections.reverse(list);
                result.add(list);
            }
        }
        return result;
    }

    // use recursive method to solve the problem
    public List<List<String>> getAllPaths(String beginWord, String endWord, Map<String, Set<String>> graph,
                                          Map<String, Boolean> visited) {
        List<List<String>> result = new ArrayList<>();
        visited.put(beginWord, true);
        // recursion termination condition
        if (beginWord.equals(endWord)) {
            List<String> oneAnswer = new ArrayList<>();
            oneAnswer.add(beginWord);
            result.add(oneAnswer);
            return result;
        }
        Set<String> allAdjacentNodes = graph.get(beginWord);
        Set<String> needCheckedAdjacentNodes = new HashSet<>();
        for (String allAdjacentNode : allAdjacentNodes) {
            if (!visited.getOrDefault(allAdjacentNode, false)) {
                needCheckedAdjacentNodes.add(allAdjacentNode);
            }
        }
        for (String adjacentNode : needCheckedAdjacentNodes) {
            Map<String, Boolean> visitedNew = new HashMap<>();
            for (String key : visited.keySet()) {
                visitedNew.put(key, visited.get(key));
            }
            List<List<String>> subResults = getAllPaths(adjacentNode, endWord, graph, visitedNew);
            for (List<String> s : subResults) {
                s.add(beginWord);
            }
            result.addAll(subResults);
        }
        return result;

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

}