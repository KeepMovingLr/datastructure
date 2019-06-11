package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution203.java, v 0.1 2019‐05‐18 11:09 PM enyi.lr Exp $$
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {

        return removeElement(head, val);
    }



    /**
     * @param head the header of the list
     * @param val  the value need to be deleted
     * @return new head after removed
     */
    private ListNode removeElement(ListNode head, int val) {
        // 最小的情况是空链表
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElement(head.next, val);
        } else {
            ListNode resultHead = removeElement(head.next, val);
            head.next = resultHead;
            return head;
        }

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
