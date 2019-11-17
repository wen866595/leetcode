package net.coderbee.leetcode.algorithm.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListCycleiiTest {

	@Test
	public void test() throws Exception {
		ListNode list = ListNode.build(-1, -7, 7, -4, 19, 6, -9, -5, -2, -5);
		ListNode nth3 = list.getNth(3);
		ListNode tail = list.getTail();
		tail.next = nth3;
		assertEquals(7, LinkedListCycleii.detectCycle(list).val);

		assertNull(LinkedListCycleii.detectCycle(ListNode.build(1, 2, 2, 4)));
	}

}
