package others.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 给定一个正数N， 打印从[1, N]的所有出站序列， 例如 N=3
 * 所有的出站序列为
 * [1,2,3]
 * [2,1,3]
 * [1,3,2]
 * [3,2,1]
 * [2,3,1]
 */
public class StackSequences {

    public static void main(String[] args) {
        int N = 2;
        List<List<Integer>> result = new ArrayList<>();
        generateSequences(N, result);
        for (List<Integer> sequence : result) {
            System.out.println(sequence);
        }
    }

    public static void generateSequences(int N, List<List<Integer>> result) {
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            input.add(i);
        }
        generateSequencesHelper(input, new Stack<>(), new ArrayList<>(), result);
    }

    private static void generateSequencesHelper(List<Integer> input, Stack<Integer> stack, List<Integer> output, List<List<Integer>> result) {
        if (input.isEmpty() && stack.isEmpty()) {
            result.add(new ArrayList<>(output));
            return;
        }

        if (!input.isEmpty()) {
            int first = input.remove(0);
            stack.push(first);
            generateSequencesHelper(input, stack, output, result);
            stack.pop();
            input.add(0, first);
        }

        if (!stack.isEmpty()) {
            int top = stack.pop();
            output.add(top);
            generateSequencesHelper(input, stack, output, result);
            output.remove(output.size() - 1);
            stack.push(top);
        }
    }
}
