package net.coderbee.leetcode.algorithm.list;

/**
 * 141. 环形链表
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head.next, fast = head.next.next;

        // 如果没有环，fast 肯定先到达链尾 null
        while (fast != null && slow != fast) {
            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return fast != null;
    }
}
