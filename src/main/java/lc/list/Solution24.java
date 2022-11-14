package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution24.java, v 0.1 2019‐06‐16 11:19 AM enyi.lr Exp $$
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        ListNode node1 = pre.next;
        ListNode node2 = node1.next;
        ListNode next = null;
        if (node2 != null) {
            next = node2.next;
        } else {
            return head;
        }

        while (pre != null) {
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;
            node1 = pre.next;
            if (pre.next != null) {
                node2 = node1.next;
            } else {
                return dummyHead.next;
            }
            if (node2 != null) {
                next = node2.next;
            } else {
                return dummyHead.next;
            }

        }
        return dummyHead.next;

    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            // swap
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;
        }
        return dummyHead.next;

    }

}