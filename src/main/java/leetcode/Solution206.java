package leetcode;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution206.java, v 0.1 2019‐05‐19 12:31 AM enyi.lr Exp $$
 */
public class Solution206 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode current = head;
        while (current.next != null) {
            ListNode needAdd = new ListNode(current.val);
            needAdd.next = dummyHead.next;
            dummyHead.next = needAdd;
            current = current.next;
        }
        return dummyHead.next;
    }

}