package lc.list;

import lc.assiststructure.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author enyi.lr
 * @version $Id: Solution82.java, v 0.1 2019‐06‐16 10:15 AM enyi.lr Exp $$
 * v2
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(1);
        ListNode current = dummyHead;

        Map<Integer, Integer> count = new LinkedHashMap<>();
        ListNode next = head;
        while (next != null) {
            if (count.containsKey(next.val)) {
                Integer num = count.get(next.val);
                num++;
                count.put(next.val, num);
            } else {
                count.put(next.val, 1);
            }
            next = next.next;
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                current.next = new ListNode(entry.getKey());
                current = current.next;
            }

        }
        return dummyHead.next;

    }

}