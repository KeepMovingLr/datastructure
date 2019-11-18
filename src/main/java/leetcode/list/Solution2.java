package leetcode.list;

import leetcode.assiststructure.ListNode;

import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: Solution2.java, v 0.1 2019‐06‐15 2:32 AM enyi.lr Exp $$
 * v2 2019/11/18
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(8);
        l1.next = l3;

        ListNode node = solution2.addTwoNumbers2(l1, l2);
        System.out.println(node);

    }

    // TODO: 2019/11/18 need check the result
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead1 = new ListNode(0);
        dummyHead1.next = l1;
        ListNode cur = l1;
        Stack<Integer> stack1 = new Stack<>();
        ListNode dummyHead2 = new ListNode(0);
        dummyHead2.next = l2;
        ListNode cur2 = l2;
        Stack<Integer> stack2 = new Stack<>();
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        double sum = 0.0;
        double i = 0;
        while (!stack1.isEmpty()) {
            double v = stack1.pop() * Math.pow(10.0, i);
            sum = sum + v;
            i++;
        }

        double sum2 = 0.0;
        double i2 = 0;
        while (!stack2.isEmpty()) {
            double v = stack2.pop() * Math.pow(10.0, i2);
            sum2 = sum2 + v;
            i2++;
        }

        int total = (int)sum + (int)sum2;
        if (total == 0){
            return new ListNode(0);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curTail = dummyHead;
        while (total != 0) {
            int v = total % 10;
            ListNode node = new ListNode(v);
            curTail.next = node;
            curTail = node;
            total = total / 10;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyNext = dummy;
        ListNode next1 = l1;
        ListNode next2 = l2;
        boolean addOne = false;
        while (next1 != null && next2 != null) {
            int val = 0;
            if (!addOne) {
                val = next1.val + next2.val;
            } else {
                val = next1.val + next2.val + 1;
            }
            if (val >= 10) {
                val = val % 10;
                addOne = true;
            } else {
                addOne = false;
            }
            dummyNext.next = new ListNode(val);
            dummyNext = dummyNext.next;

            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 == null) {
            if (addOne) {
                dummyNext.next = new ListNode(1);
                addOne = false;
            }
            return dummy.next;
        } else {
            ListNode next3;
            if (next1 != null) {
                next3 = next1;
            } else {
                next3 = next2;
            }
            // next2 != null
            while (next3 != null) {
                int val = 0;
                if (!addOne) {
                    val = next3.val;
                } else {
                    val = next3.val + 1;
                }
                if (val >= 10) {
                    val = val % 10;
                    addOne = true;
                } else {
                    addOne = false;
                }
                dummyNext.next = new ListNode(val);
                dummyNext = dummyNext.next;

                next3 = next3.next;
            }
            if (addOne) {
                dummyNext.next = new ListNode(1);
                addOne = false;
            }
            return dummy.next;
        }
    }
}