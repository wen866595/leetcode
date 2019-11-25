package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

	@Test
	public void test() throws Exception {
		assertEquals(4, LongestIncreasingSubsequence.dp(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		assertEquals(1, LongestIncreasingSubsequence.dp(new int[] { 10 }));
		assertEquals(1, LongestIncreasingSubsequence.dp(new int[] { 10, 10 }));

		assertEquals(4, LongestIncreasingSubsequence.backTraceWithMemo(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		assertEquals(1, LongestIncreasingSubsequence.backTraceWithMemo(new int[] { 10 }));
		assertEquals(1, LongestIncreasingSubsequence.backTraceWithMemo(new int[] { 10, 10 }));

		assertEquals(4, LongestIncreasingSubsequence.backTrace(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		assertEquals(1, LongestIncreasingSubsequence.backTrace(new int[] { 10 }));
		assertEquals(1, LongestIncreasingSubsequence.backTrace(new int[] { 10, 10 }));
	}

}
