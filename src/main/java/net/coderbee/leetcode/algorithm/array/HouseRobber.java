package net.coderbee.leetcode.algorithm.array;

public class HouseRobber {

	public static int rob2(int[] nums) {
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

		return Math.max(rob(nums, memo, 0, 0), rob(nums, memo, 0, 1));
	}

	static int rob(int[] nums, int[] memo, int sum, int start) {
		if (start >= nums.length) {
			return sum;
		}
		if (memo[start] >= 0) {
			return sum + memo[start];
		}

		int sub = Math.max(rob(nums, memo, nums[start], start + 2), rob(nums, memo, 0, start + 1));
		memo[start] = sub;
		return sum + sub;
	}

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
