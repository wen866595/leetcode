package net.coderbee.leetcode.algorithm.nums;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

	@Test
	public void test() {
//		int[] arr = TwoSum.twoSum(new int[] { 2, 7, 11, 15 }, 17);
//		Assert.assertTrue(arr[0] == 0 && arr[1] == 3);

		int[] arr = TwoSum.twoSum(new int[] { 3, 2, 4 }, 6);
		Assert.assertTrue(arr[0] == 1 && arr[1] == 2);
	}

}
