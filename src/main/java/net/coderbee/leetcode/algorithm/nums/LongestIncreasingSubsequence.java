package net.coderbee.leetcode.algorithm.nums;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int dp(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxSeq = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = 1 + max;
			maxSeq = Math.max(dp[i], maxSeq);
		}

		return maxSeq;
	}

	public static int backTraceWithMemo(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int[][] memo = new int[nums.length + 1][nums.length];
		for (int[] is : memo) {
			Arrays.fill(is, -1);
		}
		return backTraceWithMemo(nums, -1, 0, memo);
	}

	static int backTraceWithMemo(int[] nums, int prevIndex, int currentIndex, int[][] memo) {
		if (currentIndex >= nums.length) {
			return 0;
		}
		if (memo[prevIndex + 1][currentIndex] >= 0) {
			return memo[prevIndex + 1][currentIndex];
		}

		int taken = 0;
		if (prevIndex < 0 || nums[currentIndex] > nums[prevIndex]) {
			taken = 1 + backTraceWithMemo(nums, currentIndex, currentIndex + 1, memo);
		}

		int notTaken = backTraceWithMemo(nums, prevIndex, currentIndex + 1, memo);

		memo[prevIndex + 1][currentIndex] = Math.max(taken, notTaken);
		return memo[prevIndex + 1][currentIndex];
	}

	public static int backTrace(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		return backTrace(nums, null, 0, 0);
	}

	static int backTrace(int[] nums, Integer prev, int currentIndex, int cnt) {
		if (currentIndex >= nums.length) {
			return cnt;
		}

		int taken = 0;
		if (prev == null || nums[currentIndex] > prev) {
			taken = backTrace(nums, nums[currentIndex], currentIndex + 1, cnt + 1);
		}
		if (nums.length - currentIndex - 1 < taken - cnt) {
			return taken;
		}

		int notTaken = backTrace(nums, prev, currentIndex + 1, cnt);

		return Math.max(taken, notTaken);
	}
}
