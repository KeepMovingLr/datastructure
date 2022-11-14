package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution328.java, v 0.1 2019‐06‐15 2:22 AM enyi.lr Exp $$
 * the solution is similar with Solution86.  use two dummy head
 * v2
 */
public class Solution328 {

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
        ListNode curOdd = head;

        ListNode cur = head.next;
        ListNode pre = head;

        int i = 2;
        while (cur != null) {
            if (isOdd(i)) {
                ListNode needInsert = cur;
                pre.next = cur.next;
                cur = pre.next;

                needInsert.next = curOdd.next;
                curOdd.next = needInsert;
                curOdd = needInsert;
            } else {
                pre = cur;
                cur = cur.next;
            }
            i++;
        }
        return dummyHead.next;
    }


    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode oddDummyHeadNext = oddDummyHead;
        ListNode evenDummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode evenDummyHeadNext = evenDummyHead;

        ListNode next = head;
        int i = 1;
        while (next != null) {
            if (isOdd(i)) {
                oddDummyHeadNext.next = next;
                oddDummyHeadNext = oddDummyHeadNext.next;
            } else {
                evenDummyHeadNext.next = next;
                evenDummyHeadNext = evenDummyHeadNext.next;
            }
            i++;
            ListNode current = next;
            next = next.next;
            current.next = null;
        }
        oddDummyHeadNext.next = evenDummyHead.next;
        return oddDummyHead.next;
    }

    private boolean isOdd(int i) {
        if (i % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}