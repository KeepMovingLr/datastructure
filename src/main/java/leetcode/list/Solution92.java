package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution92.java, v 0.1 2019‐06‐14 11:57 PM enyi.lr Exp $$
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode mNode = head;
        ListNode nNode = head;
        // get m node
        for (int i = 1; i < m; i++) {
            mNode = mNode.next;
        }
        // get n node
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }
        ListNode nNext = nNode.next;
        ListNode current = mNode;
        ListNode pre = nNext;
        ListNode next = current.next;
        while (current != nNext) {
            current.next = pre;
            pre = current;
            current = next;
            if (current != null) {
                next = current.next;
            }
        }
        if (m == 1) {
            return pre;
        } else {
            ListNode a = head;
            // get a node
            for (int i = 1; i < m - 1; i++) {
                a = a.next;
            }
            a.next = pre;
            return head;
        }
    }
}

