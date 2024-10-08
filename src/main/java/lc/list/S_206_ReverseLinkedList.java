package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution206.java, v 0.1 2019‐05‐19 12:31 AM enyi.lr Exp $$
 * v2
 */
public class S_206_ReverseLinkedList {

    public ListNode reverseList5(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = head.next;

        while (current!=null){
            current.next = pre;
            pre = current;
            current = next;
            if (next != null){
                next = next.next;
            }
        }
        return pre;
    }



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

    public ListNode reverseList4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode next = current.next;
        ListNode pre = null;
        while (current != null) {
            current.next = pre;
            pre = current;
            current = next;
            if (next != null){
                next = next.next;
            }
        }
        return pre;
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