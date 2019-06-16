package leetcode.list;

import leetcode.assiststructure.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution234.java, v 0.1 2019‐06‐16 7:27 PM enyi.lr Exp $$
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (current != null) {
            stack.push(current.val);
            queue.add(current.val);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().intValue() != queue.pop().intValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode headCompare = head;
        ListNode lastCompare = head;
        while (lastCompare.next != null) {
            lastCompare = lastCompare.next;
        }
        while (headCompare != lastCompare && headCompare.next != lastCompare) {
            if (lastCompare.val != headCompare.val) {
                return false;
            }
            ListNode currentLast = lastCompare;
            lastCompare = headCompare;
            while (lastCompare.next != currentLast) {
                lastCompare = lastCompare.next;
            }
            headCompare = headCompare.next;
        }
        if (headCompare == lastCompare){
            return true;
        }
        if (headCompare.next == lastCompare){
            return headCompare.val == lastCompare.val;
        }
        return true;
    }

}