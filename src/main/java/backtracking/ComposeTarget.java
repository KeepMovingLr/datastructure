package backtracking;

import java.util.*;

/**
 * 有个二维数组，[['A','B'],['B','C'],['A','B','X'],['Y','Z']] 和一个target string 'BABY'， 问每个数组里选一个，能否组成target
 */
public class ComposeTarget {

    public boolean canGetTarget(char[][] chars, String target) {
        if (chars.length < target.length()) return false;
        List<Set<Character>> lists = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char[] cs = chars[i];
            Set<Character> set = new HashSet<>();
            for (char c : cs)
                set.add(c);
            lists.add(set);
        }
        return helper(lists, new HashSet<>(), 0, 0, target.toCharArray());
    }

    public boolean helper(List<Set<Character>> chars, Set<Integer> selectedIdx, int successGet, int idx, char[] ts) {
        if (successGet == ts.length)
            return true;
        char toGet = ts[idx];
        for (int i = 0; i < chars.size(); i++) {
            if (!selectedIdx.contains(i)) {
                Set<Character> characters = chars.get(i);
                if (!characters.contains(toGet)) {
                    continue;
                }
                selectedIdx.add(i);
                successGet++;
                if (helper(chars, selectedIdx, successGet, idx + 1, ts))
                    return true;
                successGet--;
                selectedIdx.remove(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ComposeTarget composeTarget = new ComposeTarget();
//        char[][] chars = {{'A', 'B'}, {'B', 'C'}, {'A', 'B', 'X'}, {'Y', 'Z'}};
//        char[][] chars = {{'A', 'B'}, {'B', 'C'}, {'A', 'B', 'X'}};
//        char[][] chars = {{'A', 'B'}, {'B', 'C'}, {'A', 'B', 'X'} , {'X'}};
        char[][] chars = {{'A', 'B'}, {'B', 'C'}};
        boolean res = composeTarget.canGetTarget(chars, "ABC");
        System.out.println(res);
    }
}
