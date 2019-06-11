package leetcode.list;

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

    // O(n)
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // O(n*n)
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList3(head.next);
        ListNode current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        head.next = null;
        current.next = head;
        return newHead;
    }

}