package net.coderbee.leetcode.algorithm.nums;

/**
 * 55. 跳跃游戏
 * 
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 *
 * https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length < 1) {
			return true;
		}

		int lastAblePos = nums.length - 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= lastAblePos) {
				lastAblePos = i;
			}
		}

		return lastAblePos == 0;
	}

}
