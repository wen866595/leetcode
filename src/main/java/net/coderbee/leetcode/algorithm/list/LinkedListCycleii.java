package net.coderbee.leetcode.algorithm.list;

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
