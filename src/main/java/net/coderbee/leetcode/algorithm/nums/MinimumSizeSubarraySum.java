package net.coderbee.leetcode.algorithm.nums;

public class MinimumSizeSubarraySum {

	/**
	 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
	 */
	
	// 因为数组里只有正整数，对于一个子数组 a[i]...a[j]，加入 a[j+1] 只会让新的子数组之和更大
	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int len = nums.length, tmpSum = 0, start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= s) {
				return 1;
			}
			tmpSum += nums[i];
			if (tmpSum >= s) {
				// 找到一个满足条件的子数组，确定一个结果
				if (i - start + 1 < len) {
					len = i - start + 1;
				}

				// 移动左指针尝试找到最优解
				while (tmpSum - nums[start] >= s) {
					tmpSum -= nums[start];
					start++;
					if (i - start + 1 < len) {
						len = i - start + 1;
					}
				}
			}
		}

		return tmpSum >= s ? len : 0;
	}

}
