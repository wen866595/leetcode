package net.coderbee.leetcode.algorithm.list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class RemoveNthFromEnd {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// 找出第 n 个元素
		int cnt = 0;
		ListNode ptail = head;
		while (ptail != null && cnt < n) {
			ptail = ptail.next;
			cnt++;
		}

		if (ptail == null) {
			// 刚好 n 个元素或不足 n 个元素
			if (cnt == n) {
				// 移除的是首节点
				return head.next;
			}

			// 不足 n 个元素
			return head;
		}

		// 同步后移
		ListNode pNth = head;
		while (ptail.next != null) {
			ptail = ptail.next;
			pNth = pNth.next;
		}

		pNth.next = pNth.next.next;

		return head;
	}

}
