package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution237.java, v 0.1 2019‐06‐11 12:29 PM enyi.lr Exp $$
 */
public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}