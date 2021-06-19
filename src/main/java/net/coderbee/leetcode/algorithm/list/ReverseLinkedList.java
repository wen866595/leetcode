package net.coderbee.leetcode.algorithm.list;

/**
 * 206. 反转链表.
 * 
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * @author coderbee
 *
 */
public class ReverseLinkedList {

	// 反转链表可以看作是把旧链表的元素按顺序从头部插入到新链表。
	// 把新链表的头结点初始化为 null 可以简化判断。
	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null, next;
		while (head != null) {
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

	public static ListNode reverseList1(ListNode head) {
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
