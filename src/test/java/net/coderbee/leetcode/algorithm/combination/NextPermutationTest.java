package net.coderbee.leetcode.algorithm.combination;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTest {

	@Test
	public void test() {
		int[] i0 = new int[] { 2, 3, 1 };
		NextPermutation.nextPermutation(i0);
		Assert.assertTrue(Arrays.equals(new int[] { 3, 1, 2 }, i0));

		int[] i1 = new int[] { 1, 2, 3 };
		NextPermutation.nextPermutation(i1);
		Assert.assertTrue(Arrays.equals(new int[] { 1, 3, 2 }, i1));

		int[] i2 = new int[] { 3, 2, 1 };
		NextPermutation.nextPermutation(i2);
		Assert.assertTrue(Arrays.equals(new int[] { 1, 2, 3 }, i2));

		int[] i3 = new int[] { 1, 1, 5 };
		NextPermutation.nextPermutation(i3);
		Assert.assertTrue(Arrays.equals(new int[] { 1, 5, 1 }, i3));

		int[] i4 = new int[] { 1, 3, 2 };
		NextPermutation.nextPermutation(i4);
		Assert.assertTrue(Arrays.equals(new int[] { 2, 1, 3 }, i4));
	}

}
