package net.coderbee.leetcode.algorithm.combination;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

	@Test
	public void test() throws Exception {
		List<List<Integer>> list = CombinationSumii.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
		System.out.println(list);
		assertEquals(
				Arrays.asList(Arrays.asList(1, 1, 6), Arrays.asList(1, 2, 5), Arrays.asList(1, 7), Arrays.asList(2, 6)),
				list);

		List<List<Integer>> list2 = CombinationSumii.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
		assertEquals(Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(5)), list2);
	}

	@Test
	public void testiii() throws Exception {
		List<List<Integer>> list = CombinationSumiii.combinationSum3(3, 7);
		System.out.println(list);
		assertEquals(Arrays.asList(Arrays.asList(1, 2, 4)), list);

		List<List<Integer>> list2 = CombinationSumiii.combinationSum3(3, 9);
		System.out.println(list2);
		assertEquals(Arrays.asList(Arrays.asList(1, 2, 6), Arrays.asList(1, 3, 5), Arrays.asList(2, 3, 4)), list2);

		List<List<Integer>> list3 = CombinationSumiii.combinationSum3(2, 18);
		assertEquals(Arrays.asList(), list3);
	}

}
