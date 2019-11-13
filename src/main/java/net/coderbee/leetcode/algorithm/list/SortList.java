package net.coderbee.leetcode.algorithm.list;

public class SortList {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		if (head.next.next == null) {
			// 只有两个直接排序
			ListNode next = head.next;
			if (head.val > next.val) {
				next.next = head;
				head.next = null;
				return next;
			} else {
				return head;
			}
		}

		int cnt = 0;
		ListNode pa = head;
		ListNode pb = head;

		while (pb != null) {
			cnt++;
			if ((cnt & 1) == 0) {
				pa = pa.next;
			}
			pb = pb.next;
		}
		ListNode p = pa.next;
		pa.next = null;

		ListNode ha = sortList(head);
		ListNode hb = sortList(p);
		ListNode hh = MergeTwoSortedLists(ha, hb);

		return hh;
	}

	private static ListNode MergeTwoSortedLists(ListNode ha, ListNode hb) {
		ListNode head = new ListNode(0), ph = head, pa = ha, pb = hb;

		while (pa != null && pb != null) {
			if (pa.val < pb.val) {
				ph.next = pa;
				pa = pa.next;
			} else {
				ph.next = pb;
				pb = pb.next;
			}
			ph = ph.next;
		}

		if (pa != null) {
			ph.next = pa;
		}
		if (pb != null) {
			ph.next = pb;
		}

		return head.next;
	}

}
