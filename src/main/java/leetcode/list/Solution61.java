package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution61.java, v 0.1 2019‐06‐16 6:53 PM enyi.lr Exp $$
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        // let length
        int length = 1;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        k = k % length;

        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        for (int i = 0; i < k; i++) {
            ListNode lastNode = head;
            ListNode lastNodePre = dummyHead;
            while (lastNode.next != null) {
                lastNodePre = lastNodePre.next;
                lastNode = lastNode.next;
            }
            lastNode.next = dummyHead.next;
            dummyHead.next = lastNode;
            head = dummyHead.next;
            lastNodePre.next = null;
        }
        return dummyHead.next;

    }
}