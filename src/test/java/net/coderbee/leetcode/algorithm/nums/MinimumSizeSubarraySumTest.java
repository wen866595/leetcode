package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumSizeSubarraySumTest {

	@Test
	public void test() throws Exception {
		assertEquals(0, MinimumSizeSubarraySum.minSubArrayLen(100, new int[] {}));
		assertEquals(0, MinimumSizeSubarraySum.minSubArrayLen(100, new int[] { 1, 2, 3 }));
		assertEquals(3, MinimumSizeSubarraySum.minSubArrayLen(6, new int[] { 1, 2, 3 }));
		assertEquals(1, MinimumSizeSubarraySum.minSubArrayLen(3, new int[] { 1, 2, 3 }));
		assertEquals(2, MinimumSizeSubarraySum.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		assertEquals(2, MinimumSizeSubarraySum.minSubArrayLen(15, new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 }));

	}

}
