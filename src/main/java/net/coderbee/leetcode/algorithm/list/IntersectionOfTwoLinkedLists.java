package net.coderbee.leetcode.algorithm.list;

public class IntersectionOfTwoLinkedLists {

	/**
	 * 使用双指针法，指针从某条链表出发，遍历到末尾 null 后再遍历另一条链表。 链表要么相交、要么不相交。
	 * 
	 * 不相交分析：链表 A 长度为 lenA，链表 B 长度为 lenB，指针 pa 走过 `lenA + lenB`、指针 pb 走过 `lenB +
	 * lenA` 后都会走到末尾 null 处。
	 * 
	 * 相交分析，`lenA = a + c`，`lenB = b + c`，公共部分长度为 `c` 。如果 `a == b`
	 * 则两个指针会同时达到相交的结点，如果 `a != b`，经过 `a + c + b` 或 `b + c + a` 次后，两个指针仍然会同时到达相交的结点。
	 * 
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode pa = headA, pb = headB;
		while (pa != pb) {
			pa = pa == null ? headB : pa.next;
			pb = pb == null ? headA : pb.next;
		}

		return pa;
	}

	public static ListNode getIntersectionNodeByDoublePointer(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode pa = headA, pb = headB, tailA = null, tailB = null;

		do {
			if (pa == pb) {
				return pa;
			}

			if (pa.next == null) {
				tailA = pa;
				pa = headB;
			} else {
				pa = pa.next;
			}

			if (pb.next == null) {
				tailB = pb;
				pb = headA;
			} else {
				pb = pb.next;
			}

			// 前两者确保都遍历到了尾结点
			// tailA == tailB 表示尾结点相同才是相交的链表
		} while (tailA == null || tailB == null || tailA == tailB);

		return null;
	}

}
