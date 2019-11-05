package net.coderbee.leetcode.algorithm.list;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
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
