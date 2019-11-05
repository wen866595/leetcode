package net.coderbee.leetcode.algorithm.list;

public class MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), p = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p = p.next = l1;
				l1 = l1.next;
			} else {
				p = p.next = l2;
				l2 = l2.next;
			}
		}

		while (l1 != null) {
			p = p.next = l1;
			l1 = l1.next;
		}

		while (l2 != null) {
			p = p.next = l2;
			l2 = l2.next;
		}

		return head.next;
	}

}
