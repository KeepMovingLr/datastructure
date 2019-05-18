package leetcode;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution203.java, v 0.1 2019‐05‐18 11:09 PM enyi.lr Exp $$
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {

        return method1(head, val);
    }

    // do not use dummy head
    public ListNode method1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }
        ListNode previous = head;
        while (previous.next != null) {
            if (previous.next.val == val) {
                previous.next = previous.next.next;
            } else {
                previous = previous.next;
            }
        }
        return head;
    }

    // use dummy head
    public ListNode method2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode previous = dummyHead;
        while (previous.next != null) {
            if (previous.next.val == val) {
                previous.next = previous.next.next;
            } else {
                previous = previous.next;
            }
        }
        return dummyHead.next;
    }


}
