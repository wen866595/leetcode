package net.coderbee.leetcode.algorithm.array;

/**
 * 213. 打家劫舍 II
 * 
 * 
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 */
public class HouseRobberii {

	public static int robRecursive(int[] nums) {
//		System.out.println("\n\n\n\n");

		if (nums.length < 1) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		Integer[][] cache = new Integer[nums.length][nums.length];
		return Math.max(rob(nums, 0, 0, nums.length - 2, cache), rob(nums, 0, 1, nums.length - 1, cache));
	}

	static int rob(int[] nums, int sum, int start, int end, Integer[][] cache) {
		if (start > end) {
			return sum;
		}

		if (cache[start][end] != null) {
			return sum + cache[start][end];
		}

//		System.out.println("sum:" + sum + ", start:" + start + ", end:" + end);

		int sub = Math.max(rob(nums, nums[start], start + 2, end, cache), rob(nums, 0, start + 1, end, cache));
		cache[start][end] = sub;
		return sum + sub;
	}

}
