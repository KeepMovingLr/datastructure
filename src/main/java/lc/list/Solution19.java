package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution19.java, v 0.1 2019‐06‐16 6:39 PM enyi.lr Exp $$
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            pre = pre.next;
            q = q.next;
        }
        ListNode needDeleted = pre.next;
        pre.next = pre.next.next;
        needDeleted.next = null;
        return dummyHead.next;
    }
}