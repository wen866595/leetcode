package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TopKFrequentTest {

	@Test
	public void test() throws Exception {
		assertEquals(Arrays.asList(3, 5), TopKFrequent.topKFrequent(new int[] { 5, 2, 5, 3, 5, 3, 1, 1, 3 }, 2));
		assertEquals(Arrays.asList(-1, 2), TopKFrequent.topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2));
		assertEquals(Arrays.asList(1, 2), TopKFrequent.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
		assertEquals(Arrays.asList(1), TopKFrequent.topKFrequent(new int[] { 1 }, 1));
	}

}
