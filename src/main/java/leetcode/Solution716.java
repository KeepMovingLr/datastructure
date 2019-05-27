package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution716.java, v 0.1 2019‐05‐27 12:21 AM enyi.lr Exp $$
 */
public class Solution716 {
    private static class MaxStack {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }

            }
        });
        Stack<Integer>         stack;
        Integer                max           = Integer.MIN_VALUE;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            priorityQueue.add(x);
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            Integer result = stack.pop();
            priorityQueue.remove(result);
            return result;
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            return stack.peek();
        }

        public int peekMax() {
            if (priorityQueue.isEmpty()) {
                throw new RuntimeException();
            }
            return priorityQueue.peek();
        }

        public int popMax() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            Integer remove = priorityQueue.remove();
            Stack<Integer> tempStack = new Stack<>();
            while (stack.peek() != remove && stack.size() > 1) {
                tempStack.push(stack.pop());
            }
            stack.pop();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return remove;
        }
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.popMax());
        System.out.println(stack.top());
        System.out.println(stack.peekMax());
        System.out.println(stack.pop());
        System.out.println(stack.top());

    }
}