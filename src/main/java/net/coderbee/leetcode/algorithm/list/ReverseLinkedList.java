package net.coderbee.leetcode.algorithm.list;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode p = head.next;
		head.next = null;
		while (p != null) {
			ListNode next = p.next;
			p.next = head;
			head = p;
			p = next;
		}

		return head;
	}

}
