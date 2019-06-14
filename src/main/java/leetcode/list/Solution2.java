package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution2.java, v 0.1 2019‐06‐15 2:32 AM enyi.lr Exp $$
 */
public class Solution2 {
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