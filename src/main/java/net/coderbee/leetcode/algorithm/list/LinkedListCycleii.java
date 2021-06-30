package net.coderbee.leetcode.algorithm.list;

/**
 * 142. 环形链表 II
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>
 * 环入口前 a 个结点，环上 b 个结点（包含入口结点）。
 * <p>
 * 快、慢指针分别从头结点开始，快指针一次走两步，慢指针每次走一步。
 * <p>
 * 当快、慢指针第一次相遇时分别走了 f、s 步，则有：
 * f = 2s 快指针走的步数是慢指针的2倍。
 * f = s + nb 快指针 比 慢指针多走了 n 个环长度。
 * <p>
 * 从而得到 s = nb, f = 2nb 。
 * <p>
 * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是： k = a + nb （先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
 * <p>
 * 而目前，slow 指针走过的步数为 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
 * <p>
 * 此时可以让另一个指针再从头结点出发，与 slow 同步走直至相遇，相遇结点就是环的入口节点。
 */
public class LinkedListCycleii {

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode target = head;
        while (target != slow) {
            target = target.next;
            slow = slow.next;
        }

        return target;
    }

}
