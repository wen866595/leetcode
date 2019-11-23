package net.coderbee.leetcode.algorithm.combination;

/*
 * 目标和
 * 
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class TargetSum {

	public static int findTargetSumWays(int[] nums, int sum) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		return findTargetSumWays(nums, sum, 0);
	}

	static int findTargetSumWays(int[] nums, int sum, int index) {
		if (index >= nums.length) {
			return sum == 0 ? 1 : 0;
		}

		return findTargetSumWays(nums, sum + nums[index], index + 1)
				+ findTargetSumWays(nums, sum - nums[index], index + 1);
	}

}
