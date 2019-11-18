package net.coderbee.leetcode.algorithm.nums;

public class ProductOfArrayExceptSelf {

	// 除自身以外数组的乘积
	// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
	// 输入: [1,2,3,4]
	// 输出: [24,12,8,6]
	public static int[] productExceptSelf(int[] nums) {
		int[] rs = new int[nums.length];

		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			rs[i] = product;
			product *= nums[i];
		}

		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			rs[i] *= product;
			product *= nums[i];
		}

		return rs;
	}

	public static int[] productExceptSelf3N(int[] nums) {
		int[] leftProduct = new int[nums.length];
		int[] rightProduct = new int[nums.length];
		leftProduct[0] = nums[0];
		rightProduct[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1; i < nums.length; i++) {
			leftProduct[i] = nums[i] * leftProduct[i - 1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			rightProduct[i] = nums[i] * rightProduct[i + 1];
		}

		int[] rs = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int product = 1;
			if (i > 0) {
				product = product * leftProduct[i - 1];
			}
			if (i + 1 < nums.length) {
				product = product * rightProduct[i + 1];
			}
			rs[i] = product;
		}

		return rs;
	}

	public static int[] bf(int[] nums) {
		int[] rs = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {

			int product = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					product = product * nums[j];
				}
			}
			rs[i] = product;
		}

		return rs;
	}

}
