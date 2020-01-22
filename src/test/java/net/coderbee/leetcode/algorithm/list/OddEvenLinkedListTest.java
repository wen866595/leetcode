package net.coderbee.leetcode.algorithm.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class OddEvenLinkedListTest {

	@Test
	public void test() throws Exception {
		ListNode nodes = ListNode.build(2, 1, 3, 5, 6, 4, 7);
		ListNode rs = OddEvenLinkedList.oddEvenList(nodes);
		System.out.println(rs);
		assertTrue("2->3->6->7->1->5->4".equals(rs.toString()));

		String str2 = OddEvenLinkedList.oddEvenList(ListNode.build(1, 2, 3, 4, 5)).toString();
		System.out.println(str2);
		assertTrue("1->3->5->2->4".equals(str2));
	}

}
