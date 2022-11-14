package lc.list;

import lc.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution23_1.java, v 0.1 2019‐05‐19 8:35 PM enyi.lr Exp $$
 */
public class S_23_MergeKSortedLists {

    // 分治算法，性能很好
    public ListNode mergeKLists2(ListNode[] lists) {
        int length = lists.length;
        if (length == 0){
            return null;
        }
        for (int interval = 1; interval < length; interval = interval * 2) {
            for (int i = 0; i < length; i = i + 2 * interval) {
                if (i + interval < length) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                }

            }
        }
        return lists[0];
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        ListNode begin = null;
        for (ListNode list : lists) {
            begin = mergeTwoLists(begin, list);
        }
        return begin;
    }

    /**
     * merge two lists and return the head of the new list
     * @param l1
     * @param l2
     * @return
     */
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