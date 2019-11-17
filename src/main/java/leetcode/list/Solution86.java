package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution86.java, v 0.1 2019‐06‐15 1:43 AM enyi.lr Exp $$
 * v2
 */
public class Solution86 {

    // todo
    public ListNode partition2(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // variable: satisfiedPre  satisfied  pre  cur
        ListNode satisfiedPre = dummyHead;
        ListNode satisfied = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                satisfied = satisfied.next;
                satisfiedPre = satisfiedPre.next;
            } else {
                if (satisfied != cur) {
                    pre.next = cur.next;
                    satisfiedPre.next = cur;
                    cur.next = satisfied;
                    satisfiedPre = satisfiedPre.next;
                }
            }
            cur = cur.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }


    public ListNode partition(ListNode head, int x) {
        ListNode satisfieddummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode satisfieddummyHeadNext = satisfieddummyHead;
        ListNode unSatisfieddummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode unSatisfieddummyHeadNext = unSatisfieddummyHead;
        ListNode next = head;
        while (next != null) {
            if (satisfied(next, x)) {
                satisfieddummyHeadNext.next = next;
                satisfieddummyHeadNext = satisfieddummyHeadNext.next;
            } else {
                unSatisfieddummyHeadNext.next = next;
                unSatisfieddummyHeadNext = unSatisfieddummyHeadNext.next;
            }
            ListNode current = next;
            next = next.next;
            current.next = null;
        }
        if (satisfieddummyHeadNext == satisfieddummyHead) {
            return unSatisfieddummyHead.next;
        } else {
            satisfieddummyHeadNext.next = unSatisfieddummyHead.next;
            return satisfieddummyHead.next;
        }
    }

    private boolean satisfied(ListNode node, int x) {
        if (node.val < x) {
            return true;
        } else {
            return false;
        }
    }
}