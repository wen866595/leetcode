package net.coderbee.leetcode.algorithm.nums;

public class JumpGameii {

	public int jump(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int[] steps = new int[nums.length];
		steps[nums.length - 1] = 0;
		int impossible = nums.length + 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			int min = impossible;
			int limit = Math.min(nums.length - 1, i + nums[i]);

			for (int j = i + 1; j <= limit; j++) {
				if (steps[j] < min) {
					min = steps[j];
				}
			}

			steps[i] = min + 1;
		}

		return steps[0];
	}

}
