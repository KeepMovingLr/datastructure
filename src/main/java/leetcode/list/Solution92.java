package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution92.java, v 0.1 2019‐06‐14 11:57 PM enyi.lr Exp $$
 * v2
 */
public class Solution92 {

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode mNode = head;
        ListNode nNode = head;
        for (int i = 1; i < m; i++) {
            mNode = mNode.next;
        }
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }
        ListNode nNodePreNext = nNode.next;
        ListNode mNodePrePre = null;
        if (m != 1) {
            mNodePrePre = head;
            for (int i = 1; i < m - 1; i++) {
                mNodePrePre = mNodePrePre.next;
            }
        }
        // reverse m,n
        ListNode mPre = null;
        ListNode current = mNode;
        ListNode next = mNode.next;
        while (current != nNode) {
            current.next = mPre;
            mPre = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        current.next = mPre;
        if (mNodePrePre == null){
            return current;
        }
        mNodePrePre.next = current;
        mNode.next = nNodePreNext;
        return head;
    }



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

