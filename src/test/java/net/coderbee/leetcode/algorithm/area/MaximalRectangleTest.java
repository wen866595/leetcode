package net.coderbee.leetcode.algorithm.area;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximalRectangleTest {

	@Test
	public void test() throws Exception {
		MaximalRectangle obj = new MaximalRectangle();
		assertEquals(6, obj.maximalRectangle(new char[][] {
			{ '1', '0', '1', '0', '0' },
			{ '1', '0', '1', '1', '1' },
			{ '1', '1', '1', '1', '1' },
			{ '1', '0', '0', '1', '0' }
		}));
		assertEquals(6, obj.maximalRectangle(
				new char[][] { { '1', '0', '1' },
							   { '0', '1', '1' },
							   { '1', '1', '1' },
							   { '0', '1', '1' }}));
		assertEquals(4, obj.maximalRectangle(
				new char[][] { { '1', '0', '1' },
							   { '0', '1', '1' },
							   { '1', '1', '1' },
							   { '0', '1', '0' }}));
	}

}
