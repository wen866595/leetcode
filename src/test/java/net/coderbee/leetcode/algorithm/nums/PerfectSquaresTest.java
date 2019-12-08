package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerfectSquaresTest {

	@Test
	public void test() throws Exception {
		PerfectSquares ps = new PerfectSquares();
		assertEquals(3, ps.numSquares(12));
		assertEquals(2, ps.numSquares(13));
		assertEquals(1, ps.numSquares(16));
		assertEquals(4, ps.numSquares(7168));
	}

}
