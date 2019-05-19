package leetcode;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution23_1.java, v 0.1 2019‐05‐19 8:35 PM enyi.lr Exp $$
 */
public class Solution23_1 {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode begin = null;
        for (ListNode list : lists) {
            begin = mergeTwoLists(begin, list);
        }
        return begin;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }

    }


}