package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContinuousSubarraySumTest {

	@Test
	public void test() throws Exception {
		assertTrue(ContinuousSubarraySum.isValidK(6, 3));
		assertTrue(ContinuousSubarraySum.isValidK(6, 2));
		assertFalse(ContinuousSubarraySum.isValidK(5, 3));

		assertTrue(ContinuousSubarraySum.checkSubarraySum(new int[] { 0, 0 }, 0));
		assertTrue(ContinuousSubarraySum.checkSubarraySum(new int[] { 0, 0, 0 }, 1));
		assertFalse(ContinuousSubarraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 0));
		assertTrue(ContinuousSubarraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
		assertFalse(ContinuousSubarraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 41));
		assertFalse(ContinuousSubarraySum.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 23));

		assertTrue(ContinuousSubarraySum.checkSubarraySum0(new int[] { 0, 0 }, 0));
		assertTrue(ContinuousSubarraySum.checkSubarraySum0(new int[] { 0, 0, 0 }, 1));
		assertFalse(ContinuousSubarraySum.checkSubarraySum0(new int[] { 23, 2, 4, 6, 7 }, 0));
		assertTrue(ContinuousSubarraySum.checkSubarraySum0(new int[] { 23, 2, 4, 6, 7 }, 6));
		assertFalse(ContinuousSubarraySum.checkSubarraySum0(new int[] { 23, 2, 4, 6, 7 }, 41));
		assertFalse(ContinuousSubarraySum.checkSubarraySum0(new int[] { 23, 2, 4, 6, 7 }, 23));
	}

}
