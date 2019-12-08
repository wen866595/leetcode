package net.coderbee.leetcode.algorithm.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortColorsTest {

	@Test
	public void test() throws Exception {
		int[] rs = new int[] { 0, 0, 1, 1, 2, 2 };

		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		SortColors.sortColors2(nums);
		assertTrue(Arrays.equals(rs, nums));

		int[] nums0 = new int[] { 2, 0, 2, 1, 1, 0 };
		SortColors.sortColors(nums0);
		assertTrue(Arrays.equals(rs, nums0));
	}

}
