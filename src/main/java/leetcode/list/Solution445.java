package leetcode.list;

import leetcode.assiststructure.ListNode;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution445.java, v 0.1 2019‐06‐15 2:55 AM enyi.lr Exp $$
 * v2 2019/11/18
 */
public class Solution445 {
    // TODO: 2019/11/18
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return null;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(1);
        ListNode current = dummyHead.next;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode next1 = l1;
        ListNode next2 = l2;

        while (next1 != null) {
            stack1.push(next1.val);
            next1 = next1.next;
        }

        while (next2 != null) {
            stack2.push(next2.val);
            next2 = next2.next;
        }
        Boolean needAddOne = false;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop();
            if (needAddOne) {
                sum = sum + 1;
            }
            if (sum / 10 > 0) {
                ListNode newNode = new ListNode(sum % 10);
                dummyHead.next = newNode;
                newNode.next = current;
                current = newNode;
                needAddOne = true;

            } else {
                ListNode newNode = new ListNode(sum);
                dummyHead.next = newNode;
                newNode.next = current;
                current = newNode;
                needAddOne = false;
            }
        }
        if (stack1.empty() && stack2.isEmpty()) {
            if (needAddOne) {
                ListNode newNode = new ListNode(1);
                dummyHead.next = newNode;
                newNode.next = current;
                current = newNode;
            }
            return dummyHead.next;
        }
        if (stack1.empty()) {
            stack1 = stack2;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop();
            if (needAddOne) {
                sum = sum + 1;
            }
            if (sum / 10 > 0) {
                needAddOne = true;
                ListNode newNode = new ListNode(sum % 10);
                dummyHead.next = newNode;
                newNode.next = current;
                current = newNode;

            } else {
                needAddOne = false;
                ListNode newNode = new ListNode(sum);
                dummyHead.next = newNode;
                newNode.next = current;
                current = newNode;
            }
        }
        if (needAddOne) {
            ListNode newNode = new ListNode(1);
            dummyHead.next = newNode;
            newNode.next = current;
            current = newNode;
        }
        return dummyHead.next;

    }
}