package net.coderbee.leetcode.algorithm.list;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode oddTail = head, evenTail = head.next, evenHead = evenTail, p = evenTail.next;
		boolean oddFlag = true;
		while (p != null) {
			if (oddFlag) {
				oddTail = oddTail.next = p;
			} else {
				evenTail = evenTail.next = p;
			}
			oddFlag = !oddFlag;
			p = p.next;
		}

		evenTail.next = null; // 防止死循环
		oddTail.next = evenHead;
		return head;
	}

}
