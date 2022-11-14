package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution143.java, v 0.1 2019‐06‐16 7:07 PM enyi.lr Exp $$
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }
        if (head.next.next == null) {
            return;
        }
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode current = head;
        ListNode lastNode = head;
        ListNode lastNodePre = dummyHead;
        ListNode lastNodePreC = lastNodePre;
        while (current.next != null && current.next != lastNodePreC) {
            while (lastNode.next != null) {
                lastNode = lastNode.next;
                lastNodePre = lastNodePre.next;
            }
            lastNode.next = current.next;
            current.next = lastNode;
            current = lastNode.next;
            lastNodePre.next = null;
            lastNodePreC = lastNodePre;
            // reset lastNode and lastNodePre
            lastNode = head;
            lastNodePre = dummyHead;
        }
        dummyHead.next = null;

    }

}