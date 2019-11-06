package net.coderbee.leetcode.algorithm.nums;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
	int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
	int[] nums0 = new int[] { 5, 1, 3 };

	@Test
	public void test() {
		Assert.assertEquals(0, SearchInRotatedSortedArray.search(nums0, 5));
		Assert.assertEquals(2, SearchInRotatedSortedArray.search(nums0, 3));
		Assert.assertEquals(-1, SearchInRotatedSortedArray.search(nums0, 4));

		Assert.assertEquals(4, SearchInRotatedSortedArray.search(nums, 0));
		Assert.assertEquals(-1, SearchInRotatedSortedArray.search(nums, 3));
	}

}
