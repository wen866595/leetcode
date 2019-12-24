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
		assertEquals(6, obj.maximalRectangle(new char[][] {
			{ '1', '1', '1', '0', '0' },
			{ '0', '1', '1', '1', '1' },
			{ '1', '0', '1', '1', '1' },
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
	
	@Test
	public void testDP() throws Exception {
		assertEquals(6, MaximalRectangle.maximalRectangleDP(new char[][] {
			{ '1', '0', '1', '0', '0' },
			{ '1', '0', '1', '1', '1' },
			{ '1', '1', '1', '1', '1' },
			{ '1', '0', '0', '1', '0' }
		}));
		assertEquals(6, MaximalRectangle.maximalRectangleDP(new char[][] {
			{ '1', '1', '1', '0', '0' },
			{ '0', '1', '1', '1', '1' },
			{ '1', '0', '1', '1', '1' },
			{ '1', '0', '0', '1', '0' }
		}));
		assertEquals(6, MaximalRectangle.maximalRectangleDP(
				new char[][] { { '1', '0', '1' },
							   { '0', '1', '1' },
							   { '1', '1', '1' },
							   { '0', '1', '1' }}));
		assertEquals(4,MaximalRectangle.maximalRectangleDP(
				new char[][] { { '1', '0', '1' },
							   { '0', '1', '1' },
							   { '1', '1', '1' },
							   { '0', '1', '0' }}));
	}

}
