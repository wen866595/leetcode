package net.coderbee.leetcode.algorithm.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinIncrementForUniqueTest {

	@Test
	public void test() throws Exception {
		assertEquals(1, MinIncrementForUnique.minIncrementForUnique(new int[] { 1, 2, 2 }));
		assertEquals(6, MinIncrementForUnique.minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
	}

}
