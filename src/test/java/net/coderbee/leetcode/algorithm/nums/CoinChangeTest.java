package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeTest {

	@Test
	public void test() throws Exception {
		CoinChange obj = new CoinChange();
		assertEquals(3, obj.coinChange(new int[] { 1, 2, 5 }, 11));
		assertEquals(20, obj.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
		assertEquals(-1, obj.coinChange(new int[] { 2 }, 3));

		assertEquals(3, CoinChange.coinChangeDP(new int[] { 1, 2, 5 }, 11));
		assertEquals(20, CoinChange.coinChangeDP(new int[] { 186, 419, 83, 408 }, 6249));
		assertEquals(-1, CoinChange.coinChangeDP(new int[] { 2 }, 3));

		assertEquals(3, CoinChange.coinChangeDP0(new int[] { 1, 2, 5 }, 11));
		assertEquals(20, CoinChange.coinChangeDP0(new int[] { 186, 419, 83, 408 }, 6249));
		assertEquals(-1, CoinChange.coinChangeDP0(new int[] { 2 }, 3));
	}

}
