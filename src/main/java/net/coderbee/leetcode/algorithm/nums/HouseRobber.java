package net.coderbee.leetcode.algorithm.nums;

public class HouseRobber {

	/**
	 * 打家劫舍。 https://leetcode-cn.com/problems/house-robber/ <br/>
	 * <br/>
	 * 本质是求一组和最大的不相邻数字
	 */
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] memo = new int[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}

		return Math.max(rob(memo, nums, 0), rob(memo, nums, 1));
	}

	private static int rob(int[] memo, int[] nums, int start) {
		if (memo[start] >= 0) {
			return memo[start];
		}

		int max = 0;
		for (int i = start + 2; i < nums.length; i++) {
			int j = rob(memo, nums, i);
			if (j > max) {
				max = j;
			}
		}

		memo[start] = nums[start] + max;
		return memo[start];
	}

}
