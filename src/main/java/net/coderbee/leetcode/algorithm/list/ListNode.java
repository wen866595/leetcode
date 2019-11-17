package net.coderbee.leetcode.algorithm.list;

public class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static ListNode build(int... arr) {
		ListNode head = null, p = null;
		for (int i : arr) {
			ListNode t = new ListNode(i);
			if (head == null) {
				head = p = t;
			} else {
				p.next = t;
				p = t;
			}
		}
		return head;
	}

	public String toString() {
		ListNode p = this;
		StringBuilder sb = new StringBuilder();

		do {
			if (p.next != null) {
				sb.append(p.val).append("->");
			} else {
				sb.append(p.val);
				break;
			}
			p = p.next;
		} while (p != null);

		return sb.toString();
	}

	public ListNode getNth(int n) {
		int index = 1;
		ListNode p = this;
		do {
			p = p.next;
			index++;
		} while (p != null && index < n);

		return p;
	}

	public ListNode getTail() {
		ListNode p = this;
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}

}
