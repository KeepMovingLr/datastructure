package leetcode.list;

import leetcode.assiststructure.ListNode;

/**
 * @author enyi.lr
 * @version $Id: Solution2.java, v 0.1 2019‐06‐15 2:32 AM enyi.lr Exp $$
 * v2 2019/11/18
 */
public class S_2_AddTwoNumbers {

    public static void main(String[] args) {
        S_2_AddTwoNumbers solution2 = new S_2_AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(8);
        l1.next = l3;

        ListNode node = solution2.addTwoNumbers2(l1, l2);
        System.out.println(node);

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyNext = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        boolean addOne = false;
        while (cur1 != null && cur2 != null) {
            int val = 0;
            if (!addOne) {
                val = cur1.val + cur2.val;
            } else {
                val = cur1.val + cur2.val + 1;
            }
            if (val >= 10) {
                val = val % 10;
                addOne = true;
            } else {
                addOne = false;
            }
            ListNode newNode = new ListNode(val);
            dummyNext.next = newNode;
            dummyNext = dummyNext.next;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null && cur2 == null) {
            if (addOne) {
                dummyNext.next = new ListNode(1);
                dummyNext = dummyNext.next;
            }
            return dummy.next;
        } else {
            ListNode cur3;
            if (cur1 != null) {
                cur3 = cur1;
            } else {
                cur3 = cur2;
            }
            while (cur3 != null) {
                int val = 0;
                if (addOne) {
                    val = 1 + cur3.val;
                } else {
                    val = cur3.val;
                }
                if (val >= 10) {
                    val = val % 10;
                    addOne = true;
                } else {
                    addOne = false;
                }
                dummyNext.next = new ListNode(val);
                dummyNext = dummyNext.next;
                cur3 = cur3.next;
            }
        }
        if (addOne) {
            dummyNext.next = new ListNode(1);
            dummyNext = dummyNext.next;
            addOne = false;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyNext = dummy;
        ListNode next1 = l1;
        ListNode next2 = l2;
        boolean addOne = false;
        while (next1 != null && next2 != null) {
            int val = 0;
            if (!addOne) {
                val = next1.val + next2.val;
            } else {
                val = next1.val + next2.val + 1;
            }
            if (val >= 10) {
                val = val % 10;
                addOne = true;
            } else {
                addOne = false;
            }
            dummyNext.next = new ListNode(val);
            dummyNext = dummyNext.next;

            next1 = next1.next;
            next2 = next2.next;
        }
        if (next1 == null && next2 == null) {
            if (addOne) {
                dummyNext.next = new ListNode(1);
                addOne = false;
            }
            return dummy.next;
        } else {
            ListNode next3;
            if (next1 != null) {
                next3 = next1;
            } else {
                next3 = next2;
            }
            // next2 != null
            while (next3 != null) {
                int val = 0;
                if (!addOne) {
                    val = next3.val;
                } else {
                    val = next3.val + 1;
                }
                if (val >= 10) {
                    val = val % 10;
                    addOne = true;
                } else {
                    addOne = false;
                }
                dummyNext.next = new ListNode(val);
                dummyNext = dummyNext.next;

                next3 = next3.next;
            }
            if (addOne) {
                dummyNext.next = new ListNode(1);
                addOne = false;
            }
            return dummy.next;
        }
    }
}