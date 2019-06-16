package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution25.java, v 0.1 2019‐06‐16 11:41 AM enyi.lr Exp $$
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (hasKNext(pre, k)) {
            pre.next = reverse(pre, k);
            for (int i = 0; i < k; i++) {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode pre, int k) {
        ListNode head = pre.next;
        ListNode current = pre.next;

        for (int i = 1; i < k; i++) {
            pre.next = current.next;
            current.next = pre.next.next;
            pre.next.next = head;
            head = pre.next;
        }

        return pre.next;
    }

    private boolean hasKNext(ListNode pre, int k) {
        ListNode current = pre;
        for (int i = 0; i < k; i++) {
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

}