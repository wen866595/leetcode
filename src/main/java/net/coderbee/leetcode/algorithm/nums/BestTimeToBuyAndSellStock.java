package net.coderbee.leetcode.algorithm.nums;

public class BestTimeToBuyAndSellStock {

	/**
	 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 * 
	 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
	 * 
	 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [7,1,5,3,6,4] 输出: 7 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
	 * 这笔交易所能获得利润 = 5-1 = 4 。 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
	 * 这笔交易所能获得利润 = 6-3 = 3 。
	 * 
	 * 示例 2:
	 * 
	 * 输入: [1,2,3,4,5] 输出: 4
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		int[][] profits = new int[n][n];
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (prices[i] > prices[j]) {
					profits[i][j] = prices[i] - prices[j];
				}
			}
		}

		int maxP = 0;
		for (int sellDay = 1; sellDay < prices.length - 1; sellDay++) {

		}
		return maxP;
	}

	/**
	 * 股票从买入到卖出是一个连续持有的过程，类似于求和最大的连续子数组问题。
	 */
	public static int maxProfitON(int[] prices) {
		int maxP = 0, currentP = 0;
		for (int i = 1; i < prices.length; i++) {
			currentP += prices[i] - prices[i - 1];
			if (currentP < 0) {
				currentP = 0;
			}

			if (currentP > maxP) {
				maxP = currentP;
			}
		}
		return maxP;
	}

	public static int maxProfit(int[] prices) {
		int maxP = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] > prices[i] && prices[j] - prices[i] > maxP) {
					maxP = prices[j] - prices[i];
				}
			}
		}
		return maxP;
	}

}
