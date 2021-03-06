package net.coderbee.leetcode.algorithm.nums;

public class MoveZeroes {

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 */
	public void moveZeroes(int[] nums) {
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				cnt++;
			} else {
				nums[i - cnt] = nums[i];
			}
		}

		for (int i = nums.length - cnt; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
