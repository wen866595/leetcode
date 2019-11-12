package net.coderbee.leetcode.algorithm.nums;

import static org.junit.Assert.*;

import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {

	@Test
	public void test() throws Exception {
		assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		
		assertEquals(5, BestTimeToBuyAndSellStock.maxProfitON(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(0, BestTimeToBuyAndSellStock.maxProfitON(new int[] { 7, 6, 4, 3, 1 }));

//		assertEquals(7, BestTimeToBuyAndSellStock.maxProfit2(new int[] { 7, 1, 5, 3, 6, 4 }));
//		assertEquals(0, BestTimeToBuyAndSellStock.maxProfit2(new int[] { 7, 6, 4, 3, 1 }));
//		assertEquals(4, BestTimeToBuyAndSellStock.maxProfit2(new int[] { 1, 2, 3, 4, 5 }));

	}

}
