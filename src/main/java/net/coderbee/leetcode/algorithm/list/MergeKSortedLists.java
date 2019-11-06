package net.coderbee.leetcode.algorithm.list;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length < 1) {
			return null;
		}

		int end = lists.length - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists[begin] = mergeTwoLists(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}

		return lists[0];
	}

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

		if (l1 != null) {
			p.next = l1;
		}

		if (l2 != null) {
			p.next = l2;
		}

		return head.next;
	}

	public ListNode mergeKListsByLoop(ListNode[] lists) {
		ListNode head = new ListNode(0);
		mergeInner(head, lists);
		return head.next;
	}

	private static void mergeInner(ListNode head, ListNode[] lists) {
		int min = 0;
		int minIndex = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				if (minIndex == -1) {
					minIndex = i;
					min = lists[i].val;
				} else {
					if (lists[i].val <= min) {
						min = lists[i].val;
						minIndex = i;
					}
				}
			}
		}

		if (minIndex != -1) {
			head.next = lists[minIndex];
			head = head.next;
			lists[minIndex] = lists[minIndex].next;

			mergeInner(head, lists);
		}
	}

}
