package net.coderbee.leetcode.algorithm.combination;

import java.util.Arrays;

/**
 * 分割等和子集
 * 
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 */
public class PartitionEqualSubsetSum {

	public static boolean canPartition100(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		sum = sum / 2;
		boolean[] res = new boolean[sum + 1];
		res[0] = true;
		for (int num : nums) {
			for (int i = sum; i >= num; i--) {
				res[i] = res[i] || res[i - num];
			}
		}

		return res[sum];
	}

	public static boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if ((sum & 1) == 1 || nums.length < 2) {
			return false;
		}

		int half = sum / 2;
		boolean[] memo = new boolean[half + 1];
		if (nums[0] <= half) {
			memo[nums[0]] = true;
		} else {
			return false;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > half) {
				return false;
			}
			for (int s = half; s >= nums[i]; s--) {
				memo[s] = memo[s] || memo[s - nums[i]];
			}
			if (memo[half]) {
				return true;
			}
		}

		return memo[half];
	}

	public static boolean backtrack(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if ((sum & 1) == 1 || nums.length <= 1) {
			return false;
		}

		Arrays.sort(nums);

		return canPartition(nums, sum / 2, nums.length - 1);
	}

	static boolean canPartition(int[] nums, int target, int index) {
		if (index < 0 || nums[index] > target) {
			return false;
		}
		if (target == nums[index]) {
			return true;
		}
		return canPartition(nums, target - nums[index], index - 1) || canPartition(nums, target, index - 1);
	}

}
