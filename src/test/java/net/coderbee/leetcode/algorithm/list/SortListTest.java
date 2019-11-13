package net.coderbee.leetcode.algorithm.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortListTest {

	@Test
	public void test() throws Exception {
		ListNode list = ListNode.build(4, 2, 1, 3);
		ListNode nh = SortList.sortList(list);
		String str = nh.toString();
		assertEquals("1->2->3->4", str);
	}

}
