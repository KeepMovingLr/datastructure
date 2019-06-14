package leetcode.list;

import leetcode.assiststructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution83.java, v 0.1 2019‐06‐15 1:22 AM enyi.lr Exp $$
 */
public class Solution83 {
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