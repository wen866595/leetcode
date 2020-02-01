package net.coderbee.leetcode.algorithm.array;

public class HouseRobber {

	public static int robDp0(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		// 在跌代里只使用了前两个元素，可以进化 rob3 方法的实现。
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

	public static int robDp(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		return dp[nums.length];
	}

	public static int rob3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int curMax = 0, prevMax = 0;
		for (int x : nums) {
			int temp = curMax;
			curMax = Math.max(prevMax + x, curMax);
			prevMax = temp;
		}
		return curMax;
	}

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
