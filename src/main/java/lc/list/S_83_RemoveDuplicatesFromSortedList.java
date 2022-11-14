package lc.list;

import lc.assiststructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution83.java, v 0.1 2019‐06‐15 1:22 AM enyi.lr Exp $$
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * v2
 */
public class S_83_RemoveDuplicatesFromSortedList {

    // There are many ways to solve the problem. one is use set to save the previous element. another is use the given condition: a
    // sorted linked list
    // use the condition that:Given a sorted linked list
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(head.val - 1);
        dummyHead.next = head;

        // need variable: pre cur next
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        int preValue = pre.val;
        while (cur != null) {
            if (cur.val == preValue) {
                // delete
                pre.next = next;
                cur.next = null;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            } else {
                pre = cur;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
            preValue = pre.val;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode next = head;
        ListNode pre = head;
        while (next != null) {
            if (set.contains(next.val)) {
                // remove
                pre.next = next.next;
            } else {
                set.add(next.val);
                pre = next;
            }
            next = next.next;
        }
        return head;
    }
}