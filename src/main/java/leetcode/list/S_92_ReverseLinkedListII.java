package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution92.java, v 0.1 2019‐06‐14 11:57 PM enyi.lr Exp $$
 * v2
 */
public class S_92_ReverseLinkedListII {

    // use dummy head
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // need variable: mNode  nNode mNodePre nNodeNext current pre next
        ListNode mNode = head;
        ListNode nNode = head;
        ListNode mNodePre = dummyHead;
        ListNode nNodeNext = null;
        for (int i = 1; i < m; i++) {
            mNode = mNode.next;
            mNodePre = mNodePre.next;
        }
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }
        nNodeNext = nNode.next; // nNodeNext may be null

        ListNode cur = mNode;
        ListNode pre = null;
        ListNode next = mNode.next;
        while (cur != nNodeNext){
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null){
                next = next.next;
            }
        }
        mNode.next = nNodeNext;
        mNodePre.next = nNode;
        return dummyHead.next;
    }

    // need to define variables before and know each meaning
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        // need variable: mNode  nNode mNodePre nNodeNext current pre next
        ListNode mNode = head;
        ListNode nNode = head;
        for (int i = 1; i < m; i++) {
            mNode = mNode.next;
        }
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }
        ListNode mNodePre = null;
        if (mNode != head) {
            mNodePre = head;
            for (int i = 1; i < m - 1; i++) {
                mNodePre = mNodePre.next;
            }
        }
        ListNode nNodeNext = head;
        for (int i = 1; i < n + 1; i++) {
            nNodeNext = nNodeNext.next;
        }
        // current pre next
        ListNode cur = mNode;
        ListNode pre = null;
        ListNode next = mNode.next;
        while (cur != nNodeNext) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        mNode.next = nNodeNext;
        if (mNodePre != null){
            mNodePre.next = nNode;
            return head;
        } else {
            return nNode;
        }

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

