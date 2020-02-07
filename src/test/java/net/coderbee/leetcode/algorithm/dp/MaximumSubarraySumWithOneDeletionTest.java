package net.coderbee.leetcode.algorithm.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumSubarraySumWithOneDeletionTest {

	@Test
	public void test() throws Exception {
		assertEquals(14, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { -7, 6, 1, 2, 1, 4, -1 }));
		assertEquals(17, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { 8, -1, 6, -7, -4, 5, -4, 7, -6 }));
		assertEquals(3, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { 2, 1, -3, -5 }));
		assertEquals(-2, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { -2 }));
		assertEquals(4, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { 1, -2, 0, 3 }));
		assertEquals(3, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { 1, -2, -2, 3 }));
		assertEquals(-1, MaximumSubarraySumWithOneDeletion.maximumSum(new int[] { -1, -1, -1, -1 }));
	}

}
