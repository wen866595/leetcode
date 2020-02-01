package net.coderbee.leetcode.algorithm.array;

/**
 * 213. 打家劫舍 II
 * 
 * 
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 */
public class HouseRobberii {

	public static int rob(int[] nums) {
//		System.out.println("\n\n\n\n");

		if (nums.length < 1) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int[] cache0 = new int[nums.length];
		for (int c = 0; c < cache0.length; c++) {
			cache0[c] = -1;
		}
		int[] cache1 = new int[nums.length];
		for (int c = 0; c < cache1.length; c++) {
			cache1[c] = -1;
		}
		return Math.max(rob(nums, 0, 0, nums.length - 2, cache0), rob(nums, 0, 1, nums.length - 1, cache1));
	}

	static int rob(int[] nums, int sum, int start, int end, int[] cache) {
		if (start > end) {
			return sum;
		}

		if (cache[start] >= 0) {
			return sum + cache[start];
		}

//		System.out.println("sum:" + sum + ", start:" + start + ", end:" + end);

		int sub = Math.max(rob(nums, nums[start], start + 2, end, cache), rob(nums, 0, start + 1, end, cache));
		cache[start] = sub;
		return sum + sub;
	}

}
