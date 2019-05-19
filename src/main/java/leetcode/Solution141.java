package leetcode;

import leetcode.assiststructure.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author enyi.lr
 * @version $Id: Solution141.java, v 0.1 2019‐05‐19 8:11 PM enyi.lr Exp $$
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            ListNode current2 = current;
            while (current2 != null) {
                if (current2.next == current) {
                    return true;
                }
                current2 = current2.next;
            }
            current = current.next;
        }
        return false;

    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;

    }

    public boolean hasCycle3(ListNode head) {

        return false;

    }

}