package net.coderbee.leetcode.algorithm.nums;

import java.util.HashMap;
import java.util.Map;

/**
 * 322. 零钱兑换
 * 
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CoinChange {

	public static int coinChangeDP0(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}

		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int cost = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
					cost = Math.min(cost, dp[i - coins[j]] + 1);
				}
			}
			dp[i] = cost;
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static int coinChangeDP(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}

		int[] dp = new int[amount + 1];
		return coinChangeDP(coins, amount, dp);
	}

	static int coinChangeDP(int[] coins, int amount, int[] dp) {
		if (dp[amount] != 0) {
			return dp[amount];
		}

		int count = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] > amount) {
				continue;
			} else if (coins[i] == amount) {
				count = 1;
				break;
			} else {
				int cc = coinChangeDP(coins, amount - coins[i], dp);
				if (cc != -1) {
					count = Math.min(count, 1 + cc);
				}
			}
		}

		count = count == Integer.MAX_VALUE ? -1 : count;
		dp[amount] = count;
//		System.out.println("amount:" + amount + ", count:" + count);
		return count;
	}

	public int coinChange(int[] coins, int amount) {
		if (amount <= 0) {
			return 0;
		}

		return coinChange(coins, amount, 0, new HashMap<Integer, Integer>());
	}

	int coinChange(int[] coins, int amount, int curCount, Map<Integer, Integer> cache) {
		if (cache.containsKey(amount)) {
			return cache.get(amount);
		}

		int count = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			int amt = coins[i];
			if (amt > amount) {
				continue;
			} else if (amt == amount) {
				cache.put(amount, 1);
				return 1;
			} else {
				int cc = coinChange(coins, amount - amt, curCount + 1, cache);
				if (cc != -1) {
					count = Math.min(count, 1 + cc);
				}
			}

		}

		count = count == Integer.MAX_VALUE ? -1 : count;
		cache.put(amount, count);
		return count;
	}

}
