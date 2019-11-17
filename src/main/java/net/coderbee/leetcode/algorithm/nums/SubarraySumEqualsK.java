package net.coderbee.leetcode.algorithm.nums;

public class SubarraySumEqualsK {

	// 和为 K 的连续子数组个数
	public static int subarraySum(int[] nums, int k) {
		// 1, 1, 1
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			int tmpSum = 0;
			for (int j = i; j < nums.length; j++) {
				tmpSum += nums[j];
				if (tmpSum == k) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
