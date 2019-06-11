package leetcode.attempted;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution155.java, v 0.1 2019‐05‐27 1:19 PM enyi.lr Exp $$
 */
public class Solution155 {

    class MinStack {
        Stack<Integer>         stack   = new Stack<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            minHeap.add(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            minHeap.remove(pop);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minHeap.peek();
        }
    }

}