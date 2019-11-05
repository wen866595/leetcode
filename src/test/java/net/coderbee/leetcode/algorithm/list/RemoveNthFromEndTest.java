package net.coderbee.leetcode.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

public class RemoveNthFromEndTest {

	@Test
	public void test() {
		ListNode head = ListNode.build(1, 2, 3, 4, 5);
		Assert.assertEquals(5, head.getNth(5).val);

		ListNode h0 = RemoveNthFromEnd.removeNthFromEnd(ListNode.build(1, 2, 3, 4, 5), 5);
		System.out.println(h0);
		Assert.assertEquals(2, h0.val);

		ListNode h1 = RemoveNthFromEnd.removeNthFromEnd(ListNode.build(1, 2, 3, 4, 5), 1);
		System.out.println(h1);
		Assert.assertEquals(4, h1.getNth(4).val);

		ListNode h2 = RemoveNthFromEnd.removeNthFromEnd(ListNode.build(1, 2, 3, 4, 5), 2);
		System.out.println(h2);
		Assert.assertEquals(5, h2.getNth(4).val);

		ListNode h3 = RemoveNthFromEnd.removeNthFromEnd(ListNode.build(1, 2, 3), 2);
		System.out.println(h3);
		Assert.assertEquals(1, h3.val);
		Assert.assertEquals(3, h3.getNth(2).val);
	}

}
