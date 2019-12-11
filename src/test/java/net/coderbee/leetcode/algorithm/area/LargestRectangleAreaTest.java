package net.coderbee.leetcode.algorithm.area;

import static org.junit.Assert.*;

import org.junit.Test;

import net.coderbee.leetcode.algorithm.array.LargestRectangleArea;

public class LargestRectangleAreaTest {

	@Test
	public void test() throws Exception {
		assertEquals(10, LargestRectangleArea.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
		assertEquals(2, LargestRectangleArea.largestRectangleArea(new int[] { 2 }));
		assertEquals(10, LargestRectangleArea.largestRectangleArea(new int[] { 2, 0, 5, 6, 2, 3 }));
	}

}
