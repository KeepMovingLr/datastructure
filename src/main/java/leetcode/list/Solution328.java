package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution328.java, v 0.1 2019‐06‐15 2:22 AM enyi.lr Exp $$
 * the solution is similar with Solution86.  use two dummy head
 */
public class Solution328 {


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