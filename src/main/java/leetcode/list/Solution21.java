package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution21.java, v 0.1 2019‐05‐19 1:12 AM enyi.lr Exp $$
 * v2
 */
public class Solution21 {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(1);
        ListNode current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null && l2 == null) {
            return dummyHead.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            current.next = new ListNode(l1.val);
            l1 = l1.next;
            current = current.next;
        }
        return dummyHead.next;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            // l1  l1.next merge l1
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }

    }


}