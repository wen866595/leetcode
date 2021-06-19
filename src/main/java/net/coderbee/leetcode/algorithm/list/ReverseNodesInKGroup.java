package net.coderbee.leetcode.algorithm.list;

/**
 * K 个一组翻转链表
 * 
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 进阶：
 * 
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author coderbee
 *
 */
public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tail = head;
		for (int i = 0; i < k; i++) {
			if (tail == null) {
				// 不足 K 个元素，不用翻转
				return head;
			}
			tail = tail.next;
		}

		// 翻转前 K 个元素
		ListNode newHead = reverse(head, tail);

		// 递归处理剩下的列表
		head.next = reverseKGroup(tail, k);

		return newHead;
	}

	private static ListNode reverse(ListNode head, ListNode tail) {
		ListNode newHead = null, next;
		while (head != tail) {
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

}
