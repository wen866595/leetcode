package net.coderbee.leetcode.ds;

import java.util.LinkedList;

/**
 * 最小栈
 * 
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * push(x) -- 将元素 x 推入栈中。
 * 
 * pop() -- 删除栈顶的元素。
 * 
 * top() -- 获取栈顶元素。
 * 
 * getMin() -- 检索栈中的最小元素。
 * 
 * 来源：力扣（LeetCode）
 * 
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 *
 */
public class MinStack {
	ListNode minNode = null;
	LinkedList<ListNode> list = new LinkedList<>();

	public void push(int x) {
		ListNode node = new ListNode(x);
		list.addFirst(node);

		if (minNode == null) {
			minNode = node;
		} else {
			if (x < minNode.val) {
				node.next = minNode;
				minNode = node;
			}
		}
	}

	public void pop() {
		ListNode node = list.removeFirst();
		if (node == minNode) {
			minNode = minNode.next;
		}
	}

	public int top() {
		return list.getFirst().val;
	}

	public int getMin() {
		return minNode.val;
	}

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}
}
