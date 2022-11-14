package lc.list;

import lc.assiststructure.ListNode;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution445.java, v 0.1 2019‐06‐15 2:55 AM enyi.lr Exp $$
 * v2 2019/11/26
 */
public class Solution445 {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummyNext = dummyHead.next;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        boolean needAddOne = false;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int val = stack1.pop() + stack2.pop();
            if (needAddOne) {
                val = val + 1;
            }
            if (val >= 10) {
                val = val % 10;
                needAddOne = true;
            } else {
                needAddOne = false;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = dummyNext;
            dummyHead.next = newNode;
            dummyNext = dummyHead.next;
        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            if (needAddOne) {
                ListNode newNode = new ListNode(1);
                newNode.next = dummyNext;
                dummyHead.next = newNode;
                dummyNext = dummyHead.next;
            }
            return dummyHead.next;
        }
        if (stack1.empty()) {
            stack1 = stack2;
        }
        while (!stack1.isEmpty()) {
            int val = stack1.pop();
            if (needAddOne) {
                val = val + 1;
            }
            if (val >= 10) {
                val = val % 10;
                needAddOne = true;
            } else {
                needAddOne = false;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = dummyNext;
            dummyHead.next = newNode;
            dummyNext = dummyHead.next;
        }
        if (needAddOne) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummyNext;
            dummyHead.next = newNode;
            dummyNext = dummyHead.next;

        }
        return dummyHead.next;
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